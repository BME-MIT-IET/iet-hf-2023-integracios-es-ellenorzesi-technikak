package hu.bme.iet_hf_group.wizard.graphics;

import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Field;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore.Round_Manager;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Egér nyomásfigyelő
 */
public class FieldMouseListener implements MouseListener {
    /**
     * Egérlenyomás történt
     * @param e A bekövetkezett esemény
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        MapPanel parentPanel = ((MapPanel) e.getSource());
        GameFrame gameFrame = ((GameFrame) SwingUtilities.getRoot(parentPanel));

        if (gameFrame.canMove) {
            for (Field f : Round_Manager.getInstance().getCurrentVirologist().getField().getNeighbours()) {
                if (Math.abs(e.getX() - parentPanel.getFieldPoint(f).x) < 30 && Math.abs(e.getY() - parentPanel.getFieldPoint(f).y) < 30) {
                    Round_Manager.getInstance().getCurrentVirologist().move(f);
                    gameFrame.canMove = false;
                }
            }
        }
        gameFrame.update();
    }

    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}
