package hu.bme.iet_hf_group.wizard.earlyacces_source.code;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Bear;

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
