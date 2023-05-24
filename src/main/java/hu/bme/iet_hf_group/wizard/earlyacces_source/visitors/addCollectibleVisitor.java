package hu.bme.iet_hf_group.wizard.earlyacces_source.visitors;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Gear;

public class addCollectibleVisitor implements CollectibleVisitor {
    /**
     * Material hozzáadás
     * @param m Material amit hozzá adunk
     * @param v Virológus aki kapja a Material-t
     * @return hozzáadás
     */
    @Override
    public boolean visit(Material m, Virologist v) {
        return v.add(m);
    }

    /**
     * Code hozzáadás
     * @param c Code amit hozzá adunk
     * @param v Virológus aki kapja a kódot
     * @return hozzáadás
     */
    @Override
    public boolean visit(Code c, Virologist v) {
        return v.add(c);
    }

    /***
     * Gear hozzáadás
     * @param g Gear amit hozzáadunk
     * @param v Virológus aki kapja a Geart
     * @return hozzáadás
     */
    @Override
    public boolean visit(Gear g, Virologist v) {
        return g.collect(v);
    }

}
