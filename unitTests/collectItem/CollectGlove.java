package collectItem;

import earlyacces_source.Virologist;
import earlyacces_source.field.Shelter;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.gear.Glove;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectGlove {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Glove g = new Glove();

    @Before
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
