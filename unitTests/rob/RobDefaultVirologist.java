package rob;

import earlyacces_source.Material;
import earlyacces_source.Virologist;
import earlyacces_source.field.Field;
import earlyacces_source.field.FreeField;
import earlyacces_source.state.Paralysed;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobDefaultVirologist {

    Virologist v1 = new Virologist();
    Virologist v2 = new Virologist();
    Material m = new Material();
    Field f = new FreeField();

    @Before
    public void init(){
        v1.setField(f);
        v2.setField(f);
        f.accept(v1);
        f.accept(v2);
        v1.add(m);
    }

    @Test
    public void robDefaultVirologist(){
        assertEquals(1, v1.getMaterials().size());
        assertEquals(0, v2.getMaterials().size());
        v2.rob(v1);
        assertEquals(1, v1.getMaterials().size());
        assertEquals(0, v2.getMaterials().size());
    }
}
