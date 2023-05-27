package hu.bme.iet_hf_group.wizard.useItem;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Field;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.FreeField;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore.Round_Manager;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Axe;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Bear;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UseAxeTest {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Virologist v3 = new Virologist();
    Field f1 = new FreeField();
    Field f2 = new FreeField();
    Axe a = new Axe();

    @BeforeEach
    public void init(){
        v1.setField(f1);
        v2.setField(f1);
        f1.accept(v1);
        f1.accept(v2);
        v3.setField(f2);
        f2.accept(v3);
        v3.addState(new Bear());
        Round_Manager.getInstance().addVirologists("v1", v1);
        Round_Manager.getInstance().addVirologists("v2", v2);
        Round_Manager.getInstance().addVirologists("v3", v3);
        v1.add(a);
    }

    @Test
    public void UseAxeOnDefaultVirologist(){
        assertEquals(1, v1.getGears().size());
        assertEquals(3, Round_Manager.getInstance().getNumberOfPlayer());
        v1.useGear(v2);
        assertEquals(0, v1.getGears().size());
        assertEquals(2, Round_Manager.getInstance().getNumberOfPlayer());
    }

    @Test
    public void UseAxeOnBear(){
        assertEquals(1, v1.getGears().size());
        assertEquals(3, Round_Manager.getInstance().getNumberOfPlayer());
        v1.useGear(v3);
        assertEquals(0, v1.getGears().size());
        assertEquals(2, Round_Manager.getInstance().getNumberOfPlayer());
    }

    @AfterEach
    public void end(){
        v1 = new Virologist();
        v2 = new Virologist();
        v3 = new Virologist();
        f1 = new FreeField();
        f2 = new FreeField();
        a = new Axe();
        v1.setField(f1);
        v2.setField(f1);
        f1.accept(v1);
        f1.accept(v2);
        v3.setField(f2);
        f2.accept(v3);
        v3.addState(new Bear());
        Round_Manager.getInstance().addVirologists("v1", v1);
        Round_Manager.getInstance().addVirologists("v2", v2);
        Round_Manager.getInstance().addVirologists("v3", v3);
        v1.add(a);
    }
}
