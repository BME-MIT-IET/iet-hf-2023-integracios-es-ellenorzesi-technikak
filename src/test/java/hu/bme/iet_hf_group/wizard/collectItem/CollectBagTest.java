package hu.bme.iet_hf_group.wizard.collectItem;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Bag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectBagTest {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Bag b = new Bag();

    @BeforeEach
    public void init(){
        v.setField(s);
        b.setBaseField(s);
        s.addGear(b);
    }

    @Test
    public void collectBag(){
        assertEquals(0, v.getGears().size());
        assertEquals(3, v.getMaxMaterial());
        v.searchField();
        assertEquals(1, v.getGears().size());
        assertSame(b, v.getGears().get(0));
        assertEquals(6, v.getMaxMaterial());
    }
}
