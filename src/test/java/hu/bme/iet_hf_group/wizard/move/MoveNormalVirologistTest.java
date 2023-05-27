package hu.bme.iet_hf_group.wizard.move;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Field;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.FreeField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MoveNormalVirologistTest {

    Field f1 = new FreeField();
    Field f2 = new FreeField();
    Virologist v = new Virologist();

    @BeforeEach
    public void init(){
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        v.setField(f1);
    }

    @Test
    public void moveNormalVirologist(){
        assertNotNull(" v az f1 mezon van",f1.getVirologists());
        assertNotNull(" v az f1 mezon van",v.getField());
        v.move(f2);
        assertNotNull(" v az f2 mezon van",f2.getVirologists());
        assertEquals(0, f1.getVirologists().size());
        assertSame(v, f2.getVirologists().get(0));
    }
}
