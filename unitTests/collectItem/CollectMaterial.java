package collectItem;

import earlyacces_source.Virologist;
import earlyacces_source.field.Storage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectMaterial {

    Virologist v = new Virologist();
    Storage s = new Storage();

    @Before
    public void init(){
        v.setField(s);
    }

    @Test
    public void collectOneMaterial(){
        assertEquals(0, v.getMaterials().size());
        v.searchField();
        assertEquals(1, v.getMaterials().size());
    }


    @After
    public void end(){
        s = new Storage();
        v = new Virologist();
        v.setField(s);
    }
}
