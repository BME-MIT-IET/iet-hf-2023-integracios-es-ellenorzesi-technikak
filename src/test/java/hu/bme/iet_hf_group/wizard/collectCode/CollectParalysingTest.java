
package hu.bme.iet_hf_group.wizard.collectCode;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Paralysing;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Laboratory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectParalysingTest {

    Virologist v = new Virologist();
    Paralysing p = new Paralysing();
    Laboratory l = new Laboratory(p);

    @BeforeEach
    public void init(){
        v.setField(l);
    }

    @Test
    public void collectParalysing(){
        assertEquals(0, v.getCodes().size());
        v.searchField();
        assertEquals(1, v.getCodes().size());
        assertSame(p, v.getCodes().get(0));
    }
}
