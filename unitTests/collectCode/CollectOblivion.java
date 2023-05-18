package collectCode;

import earlyacces_source.Virologist;
import earlyacces_source.code.Oblivion;
import earlyacces_source.field.Laboratory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectOblivion {

    Virologist v = new Virologist();
    Oblivion o = new Oblivion();
    Laboratory l = new Laboratory(o);

    @Before
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
