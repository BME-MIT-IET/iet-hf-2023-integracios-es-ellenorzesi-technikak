package graphics;

import earlyacces_source.Virologist;
import earlyacces_source.code.Code;
import earlyacces_source.field.Field;
import earlyacces_source.gameCore.Game;
import earlyacces_source.gameCore.Round_Manager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 * A teljes játékot kirajzoló ablak osztály
 */
public class GameFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	/**
	 * A soron lévő virológussal egy mezőn lévő virológusok
	 */
	public JComboBox<String> virologists = new JComboBox<String>();
	/**
	 * A soron lévő virológus által megtanult kódok
	 */
	public JComboBox<String> codes = new JComboBox<String>();
	/**
	 * A soron lévő virológus felszerelései
	 */
	public JTextArea inventoryTextArea = new JTextArea();
	/**
	 * Megadja, hogy a soron lévő virológus léphet-e
	 */
	public boolean canMove = true;
	/**
	 * A singleton round manager
	 */
	public Round_Manager round_manager = Round_Manager.getInstance();
	/**
	 * Az ablakon lévő menüsáv
	 */
	public GameBar gameBar;
	/**
	 * Az ablakon lévő pályakirajzoló panel
	 */
	public MapPanel mapPanel;
	/**
	 * A virológusok és a színeik párosítása
	 */
	public HashMap<String, Color> coloredVirologists = new HashMap<String, Color>();

	/**
	 * Konstruktor
	 */
	public GameFrame() {
		mapPanel= new MapPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Blind Virologists");
		setSize(1225, 660);
		setResizable(false);

		Random rand = new Random();
		for(String s : Round_Manager.getInstance().getVirologists().keySet()){
			coloredVirologists.put(s, new Color(rand.nextInt(206), rand.nextInt(206), rand.nextInt(206)));
		}
		gameBar = new GameBar();
		setJMenuBar(gameBar);
		gameBar.setVirologistColours();

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel leftPanel = new JPanel();
		add(splitPane);

		splitPane.setLeftComponent(leftPanel);
		splitPane.setRightComponent(mapPanel);
		splitPane.setDividerLocation(200);
		splitPane.setEnabled(false);


		virologists.setEditable(false);
		virologists.setPreferredSize(new Dimension(180, 30));
		virologists.setToolTipText("Az aktualis mezon allo virologusok");

		codes.setEditable(false);
		codes.setPreferredSize(new Dimension(180, 30));
		codes.setToolTipText("A soron levo virologus altal megtanult kodok");

		leftPanel.add(virologists);
		leftPanel.add(codes);

		updateInventoryText();
		inventoryTextArea.setFont(new Font("Dialog", Font.BOLD, 20));
		inventoryTextArea.setEditable(false);
		inventoryTextArea.setPreferredSize(new Dimension(180, 260));
		inventoryTextArea.setBackground(null);
		leftPanel.add(inventoryTextArea);

		String[] buttonTexts = { "Delete material", "Lubricate", "Rob", "Axe", "Search Field", "Next Round" };

		for (int i = 0; i < buttonTexts.length; i++) {
			JButton button = new JButton(buttonTexts[i]);
			button.setPreferredSize(new Dimension(180, 35));
			button.addActionListener(new PlayButtonActionListener());
			leftPanel.add(button);
		}

		setLocationRelativeTo(null);

		updateVirologists();
		updateCodes();
		updateInventoryText();
		gameBar.setTurn(round_manager.getVirologistsName(round_manager.getCurrentVirologist()));
		gameBar.setRound(round_manager.getRound());
		gameBar.setNoCodes(round_manager.getCodes().size());
		gameBar.setStates(round_manager.getCurrentVirologist());
		setVisible(true);
		mapPanel.DrawVirologists();
	}

	/**
	 * Játszma befejezése
	 */
	public void gameOver() {
		JOptionPane.showMessageDialog(this, round_manager.getVirologistsName(round_manager.getCurrentVirologist()) +
									  " won!\nBack to menu.", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
		dispose();
		new MenuFrame();
	}

	/**
	 * Következő kör
	 */
	public void nextRound() {
		Round_Manager.getInstance().doRound();
		if (Game.getInstance().getWinner() != null) {
			gameOver();
			return;
		}
		canMove = true;
		update();
		try {
			Game.getInstance().saveGame();
		} catch (IOException e) {
		}
	}

	/**
	 * Frissíti a soron lévő virológus adatait
	 */
	public void updateInventoryText() {
		String[] gears = {"-", "-", "-"};
		Virologist v = round_manager.getCurrentVirologist();
		if (v == null) return;

		for (int i = 0; i < 3; i++) {
			if (v.getGears().size() > i && v.getGears().get(i) != null)
				gears[i] = v.getGears().get(i).ToString();
		}

		inventoryTextArea.setText("Gears:\n" +
				"  " + gears[0] + "\n  " + gears[1] + "\n  " + gears[2] + "\n\n" +
				"Materials: " + v.getMaterials().size() + "/" + v.getMaxMaterial() + "\n\n" +
				"----------------------------\n");
		if (canMove)
			inventoryTextArea.append("      CAN MOVE\n----------------------------");
		else
			inventoryTextArea.append("   CANNOT MOVE\n----------------------------");
	}

	/**
	 * Frissíti a soron lévő virológus kódjait
	 */
	public void updateCodes() {
		codes.removeAllItems();
		Virologist v = round_manager.getCurrentVirologist();
		if (v == null) return;

		for (Code c : v.getCodes()) {
			codes.addItem(c.ToString());
		}
	}

	/**
	 * Frissíti a soron lévő virológussal egy mezőn lévő virológusokat
	 */
	public void updateVirologists() {
		virologists.removeAllItems();
		Virologist v = round_manager.getCurrentVirologist();
		if (v == null) return;
		Field f = v.getField();
		if (f == null) return;

		for (Virologist vx : f.getVirologists()) {
			virologists.addItem(round_manager.getVirologistsName(vx));
		}
	}

	/**
	 * Frissíti az ablakon megjelenő adatokat
	 */
	public void update() {
		updateVirologists();
		updateCodes();
		updateInventoryText();
		updateGameBar();
		mapPanel.OnDisplay();
		mapPanel.DrawVirologists();
	}

	/**
	 * Frissíti a menüsávot
	 */
	public void updateGameBar() {
		gameBar.setTurn(round_manager.getVirologistsName(round_manager.getCurrentVirologist()));
		gameBar.setRound(round_manager.getRound());
		gameBar.setNoCodes(round_manager.getCodes().size());
		gameBar.setStates(round_manager.getCurrentVirologist());
	}
}
