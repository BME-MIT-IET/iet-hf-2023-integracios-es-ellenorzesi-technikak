package hu.bme.iet_hf_group.wizard.collectCode;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.BearVirus;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.InfectiousLaboratory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectBearVirusTest {

    Virologist v = new Virologist();
    BearVirus b = new BearVirus();
    InfectiousLaboratory l = new InfectiousLaboratory(b);

    @BeforeEach
    public void init(){
        v.setField(l);
    }

    @Test
    public void collectBearVirus(){
        assertEquals(0, v.getCodes().size());
        v.searchField();
        assertEquals(1, v.getCodes().size());
        assertSame(b, v.getCodes().get(0));
    }
}
