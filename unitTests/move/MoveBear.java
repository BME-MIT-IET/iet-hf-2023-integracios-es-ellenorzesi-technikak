package move;

import earlyacces_source.Virologist;
import earlyacces_source.field.Field;
import earlyacces_source.field.FreeField;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.state.Bear;
import earlyacces_source.state.Dancing;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoveBear {

    Field f1 = new FreeField();
    Field f2 = new FreeField();
    Field f3 = new FreeField();
    Virologist v = new Virologist();

    @Before
    public void init(){
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        f1.addNeighbourField(f3);
        f3.addNeighbourField(f1);
        v.setField(f1);
        v.addState(new Bear());
    }

    @Test
    public void moveBear(){
        assertNotNull(" v az f1 mezon van",f1.getVirologists());
        assertNotNull(" v az f1 mezon van",v.getField());
        v.move(f2);
        assertNotNull("v az f3 mezon van",f3.getVirologists());
        assertEquals(0,f1.getVirologists().size());
    }
}
