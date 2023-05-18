package collectItem;

import earlyacces_source.Virologist;
import earlyacces_source.field.Shelter;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.gear.Bag;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class CollectBag {

    Virologist v = new Virologist();
    Shelter s = new Shelter();
    Bag b = new Bag();

    @Before
    public void init(){
        v.setField(s);
        b.setBaseField(s);
        s.addGear(b);
    }

    @Test
    public void collectBag(){
        assertEquals(0, v.getGears().size());
        assertEquals(3, v.getMaxMaterial());
        v.searchField();
        assertEquals(1, v.getGears().size());
        assertSame(b, v.getGears().get(0));
        assertEquals(6, v.getMaxMaterial());
    }
}
