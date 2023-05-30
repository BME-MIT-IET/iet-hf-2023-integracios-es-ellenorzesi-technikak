package hu.bme.iet_hf_group.wizard.collectItem;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Glove;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectGloveTest {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Glove g = new Glove();

    @BeforeEach
    public void init(){
        v.setField(s);
        g.setBaseField(s);
        s.addGear(g);
    }

    @Test
    public void collectGlove(){
        assertEquals(0, v.getGears().size());
        v.searchField();
        assertEquals(1,v.getGears().size());
        assertSame(g, v.getGears().get(0));
    }
}
