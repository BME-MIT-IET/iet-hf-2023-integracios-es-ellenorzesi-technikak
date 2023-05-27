package hu.bme.iet_hf_group.wizard.useCode;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Chorea;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Oblivion;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Protection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UseOblivionOnVirologistTest {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Code c1 = new Oblivion();
    Code c2 = new Chorea();
    Code c3 = new Protection();

    @BeforeEach
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

    @AfterEach
    public void end(){
        v1 = new Virologist();
        v2 = new Virologist();
        m = new Material();
        c1 = new Oblivion();
        v1.add(m);
        v1.add(c1);
    }
}
