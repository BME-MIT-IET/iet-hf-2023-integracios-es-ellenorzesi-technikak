package collectCode;

import earlyacces_source.Virologist;
import earlyacces_source.code.Chorea;
import earlyacces_source.code.Protection;
import earlyacces_source.field.Laboratory;
import earlyacces_source.gameCore.Round_Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectProtection {

    Virologist v = new Virologist();
    Protection p = new Protection();
    Laboratory l = new Laboratory(p);

    @Before
    public void init(){
        v.setField(l);
    }

    @Test
    public void collectProtection(){
        assertEquals(0, v.getCodes().size());
        v.searchField();
        assertEquals(1, v.getCodes().size());
        assertSame(p, v.getCodes().get(0));
    }
}
