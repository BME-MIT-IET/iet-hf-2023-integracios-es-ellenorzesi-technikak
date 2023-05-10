package graphics;

import earlyacces_source.gameCore.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Új játék elindítását megvalósító gombok nyomásfigyelője
 */
public class StartButtonActionListener implements ActionListener {

	/**
	 * Gombnyomás történt
	 * @param e A bekövetkezett esemény
	 */
	public void actionPerformed(ActionEvent e) {
		AbstractButton src = (AbstractButton) e.getSource();
		MenuFrame parentFrame;
		parentFrame = ((MenuFrame) SwingUtilities.getRoot(src));
		parentFrame.dispose();
			
		switch (src.getActionCommand()) {
			case "New Game": {
				Game.getInstance().newGame(parentFrame.getPlayerCount());
				new GameFrame();
				break;
			}
			case "Load Game": {
				try {
					Game.getInstance().loadGame();
				}
				catch (Exception exception) {
				}
				new GameFrame();
				break;
			}
			default: {
				break;
			}
		}
	}
}