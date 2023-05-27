package collectCode;

import earlyacces_source.Virologist;
import earlyacces_source.code.Paralysing;
import earlyacces_source.code.Protection;
import earlyacces_source.field.Laboratory;
import earlyacces_source.gameCore.Round_Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectParalysing {

    Virologist v = new Virologist();
    Paralysing p = new Paralysing();
    Laboratory l = new Laboratory(p);

    @Before
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
