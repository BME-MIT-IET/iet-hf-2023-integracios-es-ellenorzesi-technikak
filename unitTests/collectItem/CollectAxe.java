package collectItem;

import earlyacces_source.Virologist;
import earlyacces_source.field.Shelter;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.gear.Axe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectAxe {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Axe a = new Axe();

    @Before
    public void init(){
        v.setField(s);
        a.setBaseField(s);
        s.addGear(a);
    }

    @Test
    public void collectAxe(){
        assertEquals(0, v.getGears().size());
        v.searchField();
        assertEquals(1, v.getGears().size());
        assertSame(a, v.getGears().get(0));
    }
}
