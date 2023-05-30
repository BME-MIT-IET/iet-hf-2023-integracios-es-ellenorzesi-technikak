package hu.bme.iet_hf_group.wizard.graphics;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A főmenüt megjelenítő ablak osztály
 */
public class MenuFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    /**
     * Az ablakon megjelenő gombok
     */
    public static JButton buttons[]= new JButton[2];
    /**
     * Az ablakon megjelenő gombok feliratai
     */
    public static String titles[] = {"New Game", "Load Game"};
    /**
     * A játékosok száma
     */
    private int playerCount = 2;

    /**
     * Konstruktor
     * */
    public MenuFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Blind Virologists");
        setSize(500, 255);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setAlignmentX(0);

        for (int i = 0; i < 2; i++) {
            buttons[i] = new JButton();
            buttons[i].setPreferredSize(new Dimension(150, 50));
            buttons[i].setText(titles[i]);
            buttons[i].setActionCommand(titles[i]);
            buttons[i].addActionListener(new StartButtonActionListener());
            panel.add(buttons[i]);
        }

        JLabel text = new JLabel("Blind Virologists", SwingConstants.CENTER);
        text.setBackground(null);
        text.setPreferredSize(new Dimension(150, 75));
        text.setFont(new Font("Dialog", Font.BOLD, 50));

        JLabel textplayer = new JLabel("Number of players: ", SwingConstants.CENTER);
        textplayer.setBackground(null);
        textplayer.setPreferredSize(new Dimension(240, 75));
        textplayer.setFont(new Font("Dialog", Font.BOLD, 25));

        JTextField player = new JTextField("2",5);
        player.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != '\b' || player.getText().length() > 9){
                    e.consume();
                }
            }
        });

        player.getDocument().addDocumentListener(new DocumentListener()
        {
            public void changedUpdate(DocumentEvent arg0)
            {
                playerCount = Integer.parseInt(player.getText());
            }
            public void insertUpdate(DocumentEvent arg0)
            {
                playerCount = Integer.parseInt(player.getText());
            }
            public void removeUpdate(DocumentEvent arg0)
            {
                if (player.getText().length() > 0)
                    playerCount = Integer.parseInt(player.getText());
                else
                    playerCount = 2;
            }
        });
        player.setPreferredSize(new Dimension(35, 25));

        JPanel south = new JPanel();
        south.setBounds(40,80,400,100);
        south.add(textplayer);
        south.add(player);

        add(text, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * GETTERS SETTERS
     */

    public int getPlayerCount() {
        return playerCount;
    }
    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
