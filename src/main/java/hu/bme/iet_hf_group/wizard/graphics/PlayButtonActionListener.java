package hu.bme.iet_hf_group.wizard.graphics;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore.Round_Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A játék vezérlését megvalósító gombok nyomásfigyelője
 */
public class PlayButtonActionListener implements ActionListener {

	/**
	 * Gombnyomás történt
	 * @param e A bekövetkezett esemény
	 */
	public void actionPerformed(ActionEvent e) {
		AbstractButton src = (AbstractButton) e.getSource();

		GameFrame parentFrame = ((GameFrame) SwingUtilities.getRoot(src));

		switch (src.getActionCommand()) {
			case "Delete material": {
				Virologist v = Round_Manager.getInstance().getCurrentVirologist();
				v.delete(v.getMaterial());
				break;
			}
			case "Lubricate": {
				Virologist v1 = Round_Manager.getInstance().getCurrentVirologist();
				Virologist v2 = Round_Manager.getInstance().getVirologist((String) parentFrame.virologists.getSelectedItem());
				Code c = null;
				if (v1 != null && v2 != null) {
					int index = parentFrame.codes.getSelectedIndex();
					if (index >= 0)
						c = v1.getCodes().get(index);
				}
				if (c != null)
					v1.useCode(c, v2);
				break;
			}
			case "Rob": {
				Virologist v = Round_Manager.getInstance().getVirologist((String) parentFrame.virologists.getSelectedItem());
				if (v != null)
					Round_Manager.getInstance().getCurrentVirologist().rob(v);
				break;
			}
			case "Axe": {
				Virologist v = Round_Manager.getInstance().getVirologist((String) parentFrame.virologists.getSelectedItem());
				if (v != null)
					Round_Manager.getInstance().getCurrentVirologist().useGear(v);
				break;
			}
			case "Search Field": {
				Round_Manager.getInstance().getCurrentVirologist().searchField();
				break;
			}
			case "Next Round": {
				parentFrame.nextRound();
				break;
			}
			default: {
				break;
			}
		}
		parentFrame.update();
	}
}