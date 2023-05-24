package earlyacces_source.state;

import earlyacces_source.Virologist;
import earlyacces_source.code.BearVirus;
import earlyacces_source.field.Field;
import earlyacces_source.visitors.bearVisitor;

import java.util.Random;

public class Bear extends State{
    /**
     * Konstruktor
     */
    public Bear() {
        timeLeft = 999;
    }

    /**
     * Az alapállapot hatását valósítja meg
     * @return Visszatér, hogy él-e még az állapot
     */
    public boolean Do() {
        return true;
    }

    /**
     * A virológus megfelelő állapotban történő másik mezőre való lépéséért felelős. Ebben az állapotban random lép
     * @param v Az a virológus, aki lép
     * @param f Az a mező, ahova lépünk
     */
    @Override
    public void move(Virologist v, Field f) {
        Random rand = new Random();
        if (v.getField().getNeighbours().size() > 0) {
            int rnd = rand.nextInt(v.getField().getNeighbours().size());
            Field next = v.getField().getNeighbours().get(rnd);
            if (next.accept(v)) {
                v.getField().remove(v);
                v.setField(next);
                next.acceptVisitor(new bearVisitor(), v);
                for (Virologist virologist : next.getVirologists()) {
                    if(!v.equals(virologist))
                        virologist.getEffected(new BearVirus(), v);
                }
            }
        }
    }

    public boolean strongerThan(State other) {
        return other.strongerThan(this);
    }

    public boolean strongerThan(Bear other) {
        return true;
    }

    public boolean strongerThan(Immune other) {
        return true;
    }

    public boolean strongerThan(Paralysed other) {
        return true;
    }

    public boolean strongerThan(Dancing other) {
        return true;
    }

    public boolean strongerThan(Default other) {
        return true;
    }
}
