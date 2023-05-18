package useItem;

import earlyacces_source.Material;
import earlyacces_source.Virologist;
import earlyacces_source.code.Chorea;
import earlyacces_source.code.Code;
import earlyacces_source.gear.Cape;
import earlyacces_source.gear.Gear;
import earlyacces_source.gear.Glove;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UseCape {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Gear g = new Cape();
    Code c = new Chorea();

    @Before
    public void init(){
        v1.add(m);
        v1.add(c);
        v2.add(g);
    }

    @Test
    public void UseCape(){
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        assertEquals(1, v2.getStates().size());
        assertEquals("Default: 000", v2.getStates().get(0).ToString());
        v1.useCode(c, v2);
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        assertEquals(1, v2.getStates().size());
        assertEquals("Default: 000", v2.getStates().get(0).ToString());
    }
}
