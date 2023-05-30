package collectCode;

import earlyacces_source.Virologist;
import earlyacces_source.code.Chorea;
import earlyacces_source.field.Laboratory;
import earlyacces_source.gameCore.Round_Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectChorea {

    Virologist v = new Virologist();
    Chorea c = new Chorea();
    Laboratory l = new Laboratory(c);

    @Before
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
