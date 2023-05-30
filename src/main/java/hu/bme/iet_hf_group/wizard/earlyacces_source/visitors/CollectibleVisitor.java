package hu.bme.iet_hf_group.wizard.earlyacces_source.visitors;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Gear;

public interface CollectibleVisitor {
    boolean visit(Material m, Virologist v);
    boolean visit(Gear g, Virologist v);
    boolean visit(Code c, Virologist v);
}
