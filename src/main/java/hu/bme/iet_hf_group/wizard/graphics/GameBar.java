package graphics;

import earlyacces_source.Virologist;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.state.State;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

/**
 * Menüsáv osztály
 */
public class GameBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	/**
	 * Az aktuális kör
	 */
	JMenu round = new JMenu();
	/**
	 * A játékban található kódok száma
	 */
	JMenu noCodes = new JMenu();
	/**
	 * A soron lévő virológus állapotai
	 */
	JMenu states = new JMenu("States");
	/**
	 * A soron lévő virológus
	 */
	JMenu turn = new JMenu();
	/**
	 * A játékban alkalmazott színkódolás
	 */
	JMenu coloursMenu = new JMenu("Colours");

	/**
	 * Konstruktor
	 */
	public GameBar() {
		JMenu mainMenu = new JMenu("Menu");
		mainMenu.setActionCommand("Menu");
		mainMenu.addMenuListener(new MainMenuButtonMenuListener());

		Color[] colours = {new Color(0, 120, 0), new Color(180,120,90), Color.BLACK, Color.MAGENTA, Color.MAGENTA};
		String[] fields = {"FreeField", "Storage", "Shelter", "Laboratory", "Infectious Laboratory"};

		for (int i = 0; i < fields.length; i++) {
			JMenuItem item = new JMenuItem(fields[i]);
			item.setForeground(colours[i]);
			coloursMenu.add(item);
		}

		round.setForeground(Color.RED);
		noCodes.setForeground(Color.RED);

		add(mainMenu);
		add(coloursMenu);
		add(round);
		add(noCodes);
		add(states);
		add(new JSeparator());
		add(turn);
	}

	/**
	 * GETTERS SETTERS
	 */

	public void setRound(int r) {
		round.setText("ROUND: " + String.format("%03d", r));
	}

	public void setNoCodes(int n) {
		noCodes.setText("Number of Codes: " + String.format("%03d", n));
	}

	public void setTurn(String name) {
		turn.setText("Virologist: " + name);
	}

	public void setStates(Virologist v) {
		states.removeAll();
		if (v == null) return;
		for (State s : v.getStates()) {
			states.add(new JMenuItem(s.ToString()));
		}
	}

	public void setVirologistColours() {
		for(String s: ((GameFrame) SwingUtilities.getRoot(this)).coloredVirologists.keySet()){
			JMenuItem item = new JMenuItem(s);
			item.setForeground(((GameFrame) SwingUtilities.getRoot(this)).coloredVirologists.get(s));
			coloursMenu.add(item);
		}
	}
}
