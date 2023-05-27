package hu.bme.iet_hf_group.wizard.collectCode;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Chorea;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Laboratory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectChoreaTest {

    Virologist v = new Virologist();
    Chorea c = new Chorea();
    Laboratory l = new Laboratory(c);

    @BeforeEach
    public void init(){
        v.setField(l);
    }

    @Test
    public void collectChorea(){
        assertEquals(0, v.getCodes().size());
        v.searchField();
        assertEquals(1,v.getCodes().size());
        assertSame(c, v.getCodes().get(0));
    }
}
