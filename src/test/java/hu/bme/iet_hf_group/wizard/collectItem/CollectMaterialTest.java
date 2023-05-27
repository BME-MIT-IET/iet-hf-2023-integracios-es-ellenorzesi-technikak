package hu.bme.iet_hf_group.wizard.collectItem;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Storage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class CollectMaterialTest {

    Virologist v = new Virologist();
    Storage s = new Storage();

    @BeforeEach
    public void init(){
        v.setField(s);
    }

    @Test
    public void collectOneMaterial(){
        assertEquals(0, v.getMaterials().size());
        v.searchField();
        assertEquals(1, v.getMaterials().size());
    }


    @AfterEach
    public void end(){
        s = new Storage();
        v = new Virologist();
        v.setField(s);
    }
}
