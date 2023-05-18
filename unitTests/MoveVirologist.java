import earlyacces_source.Virologist;
import earlyacces_source.field.Field;
import earlyacces_source.field.FreeField;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.state.Dancing;
import earlyacces_source.state.Paralysed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveVirologist {

    Field f1;
    Field f2;
    Virologist v;


    @Before
    public void initMoveVirologist(){
        Round_Manager.getInstance().addVirologists("v",new Virologist());
        Round_Manager.getInstance().addField("f1", new FreeField());
        Round_Manager.getInstance().addField("f2", new FreeField());
        f1 = Round_Manager.getInstance().getField("f1");
        f2 = Round_Manager.getInstance().getField("f2");
        v = Round_Manager.getInstance().getVirologist("v");
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        v.setField(f1);
    }

    @Test
    public void moveVirologist(){
        assertNotNull(" v az f1-en van",f1.getVirologists());
        assertNotNull(" v az f1-en van",v.getField());
        v.move(f2);
        assertNotNull(" v az f1-en van",f2.getVirologists());
        assertEquals(f1.getVirologists().size(),0 );
        assertSame(v,f2.getVirologists().get(0));
    }

    @Before
    public void initMoveParalyzedVirologist(){
        Round_Manager.getInstance().addVirologists("v",new Virologist());
        Round_Manager.getInstance().addField("f1", new FreeField());
        Round_Manager.getInstance().addField("f2", new FreeField());
        f1 = Round_Manager.getInstance().getField("f1");
        f2 = Round_Manager.getInstance().getField("f2");
        v = Round_Manager.getInstance().getVirologist("v");
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        v.setField(f1);
        v.addState(new Paralysed());
    }

    @Test
    public void moveParalyzedVirologist(){
        assertNotNull(" v az f1-en van",f1.getVirologists());
        assertNotNull(" v az f1-en van",v.getField());
        v.move(f2);
        assertNotNull(" v az f1-en van",f1.getVirologists());
        assertNotNull(" v az f1-en van",v.getField());
    }

    Field f3;

    @Before
    public void initMoveDancingVirologist(){
        Round_Manager.getInstance().addVirologists("v",new Virologist());
        Round_Manager.getInstance().addField("f1", new FreeField());
        Round_Manager.getInstance().addField("f2", new FreeField());
        Round_Manager.getInstance().addField("f3", new FreeField());
        f1 = Round_Manager.getInstance().getField("f1");
        f2 = Round_Manager.getInstance().getField("f2");
        f3 = Round_Manager.getInstance().getField("f3");
        v = Round_Manager.getInstance().getVirologist("v");
        f1.addNeighbourField(f2);
        f2.addNeighbourField(f1);
        f1.addNeighbourField(f3);
        f3.addNeighbourField(f1);
        v.setField(f1);
        v.addState(new Dancing());
    }

    @Test
    public void moveDancingVirologist(){
        assertNotNull(" v az f1-en van",f1.getVirologists());
        assertNotNull(" v az f1-en van",v.getField());
        v.move(f2);
        assertNotNull("v az f3-on van",f3.getVirologists());
        assertEquals(f1.getVirologists().size(),0);
    }

}