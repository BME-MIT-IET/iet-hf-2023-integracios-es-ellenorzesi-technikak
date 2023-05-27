package useCode;

import earlyacces_source.Virologist;
import earlyacces_source.code.BearVirus;
import earlyacces_source.field.Field;
import earlyacces_source.field.FreeField;
import earlyacces_source.field.InfectiousLaboratory;
import earlyacces_source.state.Bear;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetInfectedByBearVirus {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Field f1 = new InfectiousLaboratory(new BearVirus());
    Field f2 = new FreeField();
    Field f3 = new FreeField();

    @Before
    public void init(){
        v1.setField(f2);
        f2.accept(v1);
        v2.addState(new Bear());
        v2.setField(f3);
        f3.accept(v2);
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        f3.addNeighbourField(f2);
        f2.addNeighbourField(f3);
    }

    @Test
    public void SearchInfectiousLaboratory(){
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        v1.move(f1);
        v1.searchField();
        assertEquals(2, v1.getStates().size());
        assertEquals("Bear: 999", v1.getStates().get(0).ToString());
        assertEquals("Default: 000", v1.getStates().get(1).ToString());
    }

    @Test
    public void GetInfectedByBear(){
        assertEquals(1, v1.getStates().size());
        assertEquals("Default: 000", v1.getStates().get(0).ToString());
        v2.move(f2);
        assertEquals(2, v1.getStates().size());
        assertEquals("Bear: 999", v1.getStates().get(0).ToString());
        assertEquals("Default: 000", v1.getStates().get(1).ToString());
    }

    @After
    public void end(){
        v1 = new Virologist();
        v2 = new Virologist();
        f1 = new InfectiousLaboratory(new BearVirus());
        f2 = new FreeField();
        v1.setField(f2);
        f2.accept(v1);
        v2.addState(new Bear());
        v2.setField(f3);
        f3.accept(v2);
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        f3.addNeighbourField(f2);
        f2.addNeighbourField(f3);
    }
}
