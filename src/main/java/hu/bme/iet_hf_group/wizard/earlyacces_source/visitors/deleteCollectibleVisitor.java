package hu.bme.iet_hf_group.wizard.earlyacces_source.visitors;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Gear;

public class deleteCollectibleVisitor implements CollectibleVisitor {
    @Override
    public boolean visit(Material m, Virologist v) {
        v.delete(m);
        return true;
    }

    @Override
    public boolean visit(Gear g, Virologist v) {
        g.remove(v);
        v.delete(g);

        return true;
    }

    @Override
    public boolean visit(Code c, Virologist v) {
        v.delete(c);
        return true;    }
}
