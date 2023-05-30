package hu.bme.iet_hf_group.wizard.collectItem;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Axe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectAxeTest {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Axe a = new Axe();

    @BeforeEach
    public void init(){
        v.setField(s);
        a.setBaseField(s);
        s.addGear(a);
    }

    @Test
    public void collectAxe(){
        assertEquals(0, v.getGears().size());
        v.searchField();
        assertEquals(1, v.getGears().size());
        assertSame(a, v.getGears().get(0));
    }
}
