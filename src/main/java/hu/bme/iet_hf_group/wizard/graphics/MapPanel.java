package graphics;

import earlyacces_source.Virologist;
import earlyacces_source.field.Field;
import earlyacces_source.gameCore.Round_Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * A pályát kirajzoló panel osztály
 */
public class MapPanel extends JLayeredPane {
    /**
     * A kirajzolandó pálya képe
     */
    public JLabel map = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("map.png"))));
    /**
     * Rajzoló felület
     */
    public BufferedImage dot = new BufferedImage(1000, 600, BufferedImage.TYPE_INT_ARGB);
    /**
     * A kirajzolandó mezők koordinátái
     */
    public final MyPoint[] points = {
            new MyPoint(40,73),
            new MyPoint(171,58),
            new MyPoint(279,23),
            new MyPoint(353,60),
            new MyPoint(425,58),
            new MyPoint(500,68),
            new MyPoint(618,32),
            new MyPoint(745,50),
            new MyPoint(837,38),
            new MyPoint(949,64),
            new MyPoint(847,138),
            new MyPoint(771,176),
            new MyPoint(671,117),
            new MyPoint(575,111),
            new MyPoint(373,154),
            new MyPoint(281,104),
            new MyPoint(192,177),
            new MyPoint(88,155),
            new MyPoint(39,308),
            new MyPoint(130,326),
            new MyPoint(209,296),
            new MyPoint(306,245),
            new MyPoint(409,256),
            new MyPoint(491,255),
            new MyPoint(569,270),
            new MyPoint(635,204),
            new MyPoint(728,265),
            new MyPoint(829,298),
            new MyPoint(934,211),
            new MyPoint(941,321),
            new MyPoint(950,422),
            new MyPoint(841,451),
            new MyPoint(739,392),
            new MyPoint(641,323),
            new MyPoint(562,388),
            new MyPoint(444,372),
            new MyPoint(341,383),
            new MyPoint(245,452),
            new MyPoint(132,420),
            new MyPoint(34,491),
            new MyPoint(90,537),
            new MyPoint(169,531),
            new MyPoint(247,565),
            new MyPoint(358,543),
            new MyPoint(468,468),
            new MyPoint(491,553),
            new MyPoint(633,487),
            new MyPoint(728,558),
            new MyPoint(842,559),
            new MyPoint(955,547)
    };

    /**
     * A kirajzolandó mezők és a koordináták párosítása
     */
    HashMap<MyPoint, Field> coords;

    /**
     * Konstruktor
     */
    public MapPanel() {
        LayoutManager overlay = new OverlayLayout(this);
        setLayout(overlay);
        addMouseListener(new FieldMouseListener());

        add(map, 0, 0);

        JLabel picLabel = new JLabel(new ImageIcon(dot));
        add(picLabel, 1,0);

        coords = new HashMap<MyPoint, Field>();
        LinkedList<Field> fields = Round_Manager.getInstance().getFields();
        if (fields != null) {
            for (int i = 0; i < Math.min(fields.size(), points.length); i++) {
                coords.put(points[i],fields.get(i));
            }
        }
        OnDisplay();
    }

    /**
     * Koordináta osztály
     */
    class MyPoint {
        int x, y;
        MyPoint(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    /**
     * Ablak kirajzolása
     */
    public void OnDisplay() {
        Graphics2D g = (Graphics2D) dot.getGraphics();
        update(g);
        FieldColourVisitor fieldColourVisitor = new FieldColourVisitor();

        for(int i = 0; i < coords.size(); i++){
            g.setColor(coords.get(points[i]).acceptColorVisitor(fieldColourVisitor));
            g.fillOval(points[i].x, points[i].y, 20, 20);
        }
    }

    /**
     * Virológusok kirajzolása
     */
    public void DrawVirologists() {
        Graphics2D g = (Graphics2D) dot.getGraphics();

        for (Field f : Round_Manager.getInstance().getFields()) {
            int number = f.getVirologists().size();
            for (int i = 0; i < number; i++) {
                Virologist v = f.getVirologists().get(i);
                MyPoint vPoint = new MyPoint(Objects.requireNonNull(SearchKeyWithValue(coords, f)).x, Objects.requireNonNull(SearchKeyWithValue(coords, f)).y);
                vPoint.x += Math.cos(Math.PI * 2 / number * i) * 25;
                vPoint.y += Math.sin(Math.PI * 2 / number * i) * 25;

                g.setColor(((GameFrame) SwingUtilities.getRoot(this)).coloredVirologists.get(Round_Manager.getInstance().getVirologistsName(v)));
                g.fillOval(vPoint.x, vPoint.y, 10, 10);
            }
        }
        repaint();
    }

    /**
     * GETTERS SETTERS
     */

    public MyPoint getFieldPoint(Field f) {
        return SearchKeyWithValue(coords, f);
    }

    private static <T> MyPoint SearchKeyWithValue(HashMap<MyPoint,T> dic, T searchItem) {
        for (Map.Entry<MyPoint, T> entry : dic.entrySet()) {
            if (entry.getValue() == searchItem)
                return entry.getKey();
        }
        return null;
    }
}
