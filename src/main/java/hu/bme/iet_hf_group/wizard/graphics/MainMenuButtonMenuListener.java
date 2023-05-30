package hu.bme.iet_hf_group.wizard.graphics;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Menüsáv nyomásfigyelője
 */
public class MainMenuButtonMenuListener implements MenuListener {

	/**
	 * Menüelem kiválasztás történt
	 * @param e A bekövetkezett esemény
	 */
	public void menuSelected(MenuEvent e) {
		AbstractButton src = (AbstractButton) e.getSource();
		
		((JFrame) SwingUtilities.getRoot(src)).dispose();
		
		new MenuFrame();
	}

	public void menuDeselected(MenuEvent e) { }
	public void menuCanceled(MenuEvent e) { }
}