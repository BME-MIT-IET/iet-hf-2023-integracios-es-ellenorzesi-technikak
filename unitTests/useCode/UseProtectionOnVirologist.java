package useCode;

import earlyacces_source.Material;
import earlyacces_source.Virologist;
import earlyacces_source.code.Chorea;
import earlyacces_source.code.Code;
import earlyacces_source.code.Protection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UseProtectionOnVirologist {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Code c = new Protection();

    @Before
    public void init(){
        v1.add(m);
        v1.add(c);
    }

    @Test
    public void useProtectionOnVirologist(){
        assertEquals(1, v2.getStates().size());
        assertEquals("Default: 000", v2.getStates().get(0).ToString());
        v1.useCode(c, v2);
        assertEquals(2, v2.getStates().size());
        assertEquals("Immune: 005", v2.getStates().get(0).ToString());
        assertEquals("Default: 000", v2.getStates().get(1).ToString());
    }

    @Test
    public void useProtectionOnSelf(){
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        v1.useCode(c, v1);
        assertEquals(2, v1.getStates().size());
        assertEquals("Immune: 005", v1.getStates().get(0).ToString());
        assertEquals("Default: 000", v1.getStates().get(1).ToString());
    }

    @After
    public void end(){
        v1 = new Virologist();
        v2 = new Virologist();
        m = new Material();
        c = new Protection();
        v1.add(m);
        v1.add(c);
    }
}
