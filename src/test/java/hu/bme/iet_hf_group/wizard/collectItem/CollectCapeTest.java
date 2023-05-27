package hu.bme.iet_hf_group.wizard.collectItem;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Cape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectCapeTest {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Cape c = new Cape();

    @BeforeEach
    public void init(){
        v.setField(s);
        c.setBaseField(s);
        s.addGear(c);
    }

    @Test
    public void collectCape(){
        assertEquals(0, v.getGears().size());
        v.searchField();
        assertEquals(1,v.getGears().size());
        assertSame(c, v.getGears().get(0));
    }
}
