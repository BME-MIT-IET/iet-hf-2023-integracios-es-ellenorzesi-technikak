package hu.bme.iet_hf_group.wizard.rob;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Field;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.FreeField;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Paralysed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RobParalysedVirologist {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Field f = new FreeField();

    @BeforeEach
    public void init(){
        v1.setField(f);
        v2.setField(f);
        f.accept(v1);
        f.accept(v2);
        v1.add(m);
        v1.addState(new Paralysed());
    }

    @Test
    public void robParalysedVirologist(){
        assertEquals(1, v1.getMaterials().size());
        assertEquals(0, v2.getMaterials().size());
        v2.rob(v1);
        assertEquals(0, v1.getMaterials().size());
        assertEquals(1, v2.getMaterials().size());
    }
}
