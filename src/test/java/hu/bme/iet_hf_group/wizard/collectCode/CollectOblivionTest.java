package hu.bme.iet_hf_group.wizard.collectCode;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Oblivion;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Laboratory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectOblivionTest {

    Virologist v = new Virologist();
    Oblivion o = new Oblivion();
    Laboratory l = new Laboratory(o);

    @BeforeEach
    public void init(){
        v.setField(l);
    }

    @Test
    public void collectOblivion(){
        assertEquals(0, v.getCodes().size());
        v.searchField();
        assertEquals(1, v.getCodes().size());
        assertSame(o, v.getCodes().get(0));
    }
}
