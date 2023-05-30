package useCode;

import earlyacces_source.Material;
import earlyacces_source.Virologist;
import earlyacces_source.code.Chorea;
import earlyacces_source.code.Code;
import earlyacces_source.code.Oblivion;
import earlyacces_source.code.Protection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UseOblivionOnVirologist {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Code c1 = new Oblivion();
    Code c2 = new Chorea();
    Code c3 = new Protection();

    @Before
    public void init(){
        v1.add(m);
        v1.add(c1);
        v2.add(c2);
        v2.add(c3);
    }

    @Test
    public void useOblivionOnVirologist(){
        assertEquals(1, v2.getStates().size());
        assertEquals("Default: 000", v2.getStates().get(0).ToString());
        assertEquals(2, v2.getCodes().size());
        v1.useCode(c1, v2);
        assertEquals(1, v2.getStates().size());
        assertEquals("Default: 000", v2.getStates().get(0).ToString());
        assertEquals(0, v2.getCodes().size());
    }

    @Test
    public void useOblivionOnSelf(){
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        assertEquals(1, v1.getCodes().size());
        v1.useCode(c1, v1);
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        assertEquals(0, v1.getCodes().size());
    }

    @After
    public void end(){
        v1 = new Virologist();
        v2 = new Virologist();
        m = new Material();
        c1 = new Oblivion();
        v1.add(m);
        v1.add(c1);
    }
}
