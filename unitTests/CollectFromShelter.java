import earlyacces_source.Virologist;
import earlyacces_source.field.Shelter;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.gear.Cape;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CollectFromShelter {
    Shelter f;
    Virologist v;

    @Before
    public void initCollectCapeFromShelter(){
        Round_Manager.getInstance().addVirologists("v",new Virologist());
        Round_Manager.getInstance().addField("f", new Shelter());
        f = (Shelter)Round_Manager.getInstance().getField("f");
        v = Round_Manager.getInstance().getVirologist("v");
        v.setField(f);
        Cape c = new Cape();
        c.setBaseField(f);
        f.addGear(c);
    }

    @Test
    public void collectCapeFromShelter(){
        assertEquals(v.getGears().size(), 0);
        v.searchField();
        assertEquals(v.getGears().size(),1);
    }

    @Before
    public void initCollectBagFromShelter(){

    }

    @Test
    public void collectBagFromShelter(){

    }

    @Before
    public void initCollectGloveFromShelter(){

    }

    @Test
    public void collectGloveFromShelter(){

    }

    @Before
    public void initcollectAxeFromShelter() {

    }


}