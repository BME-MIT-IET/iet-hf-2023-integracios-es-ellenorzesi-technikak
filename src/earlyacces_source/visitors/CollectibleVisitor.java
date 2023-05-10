package earlyacces_source.visitors;

import earlyacces_source.Material;
import earlyacces_source.Virologist;
import earlyacces_source.code.Code;
import earlyacces_source.gear.Bag;
import earlyacces_source.gear.Gear;

public interface CollectibleVisitor {
    boolean visit(Material m, Virologist v);
    boolean visit(Gear g, Virologist v);
    boolean visit(Code c, Virologist v);
}
