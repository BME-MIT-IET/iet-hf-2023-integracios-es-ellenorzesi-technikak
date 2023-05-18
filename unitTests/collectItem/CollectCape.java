package collectItem;

import earlyacces_source.Virologist;
import earlyacces_source.field.Shelter;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.gear.Cape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectCape {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Cape c = new Cape();

    @Before
    public void init(){
        v.setField(s);
        c.setBaseField(s);
        s.addGear(c);
    }

    @Test
    public void collectCape(){
        assertEquals(0, v.getGears().size());
        v.searchField();
        assertEquals(1,v.getGears().size());
        assertSame(c, v.getGears().get(0));
    }
}
