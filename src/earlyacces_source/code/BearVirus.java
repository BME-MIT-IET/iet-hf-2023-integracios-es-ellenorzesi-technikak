package earlyacces_source.code;

import earlyacces_source.Virologist;
import earlyacces_source.state.Bear;
import earlyacces_source.state.Dancing;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A medvevírust megvalósító osztály
 */
public class BearVirus extends Code  {
    /***
     * Konstruktor
     */
    public BearVirus() {
        neededMaterials = new ArrayList<>();
    }

    /**
     * Állapotváltás
     * @param v Az a virológus, akire a hatás kifejtődik
     */
    @Override
    public void setState(Virologist v) {
        v.addState(new Bear());
        v.delete(v.getMaterial());
    }
}
