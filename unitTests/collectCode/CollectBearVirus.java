package collectCode;

import earlyacces_source.Virologist;
import earlyacces_source.code.BearVirus;
import earlyacces_source.field.InfectiousLaboratory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectBearVirus {

    Virologist v = new Virologist();
    BearVirus b = new BearVirus();
    InfectiousLaboratory l = new InfectiousLaboratory(b);

    @Before
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
