package hu.bme.iet_hf_group.wizard.useCode;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Chorea;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UseChoreaOnVirologistTest {
    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Code c = new Chorea();

    @BeforeEach
    public void init(){
        v1.add(m);
        v1.add(c);
    }

    @Test
    public void useChoreaOnVirologist(){
        assertEquals(1, v2.getStates().size());
        assertEquals("Default: 000", v2.getStates().get(0).ToString());
        v1.useCode(c, v2);
        assertEquals(2, v2.getStates().size());
        assertEquals("Dancing: 005", v2.getStates().get(0).ToString());
        assertEquals("Default: 000", v2.getStates().get(1).ToString());
    }

    @Test
    public void useChoreaOnSelf(){
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        v1.useCode(c, v1);
        assertEquals(2, v1.getStates().size());
        assertEquals("Dancing: 005", v1.getStates().get(0).ToString());
        assertEquals("Default: 000", v1.getStates().get(1).ToString());
    }

    @AfterEach
    public void end(){
        v1 = new Virologist();
        v2 = new Virologist();
        m = new Material();
        c = new Chorea();
        v1.add(m);
        v1.add(c);
    }
}
