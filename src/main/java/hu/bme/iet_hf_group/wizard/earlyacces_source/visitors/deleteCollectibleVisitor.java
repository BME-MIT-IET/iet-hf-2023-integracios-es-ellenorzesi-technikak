package earlyacces_source.visitors;

import earlyacces_source.Material;
import earlyacces_source.Virologist;
import earlyacces_source.code.Code;
import earlyacces_source.gameCore.Game;
import earlyacces_source.gear.Bag;
import earlyacces_source.gear.Gear;

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
