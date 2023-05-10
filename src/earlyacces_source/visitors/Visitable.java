package earlyacces_source.visitors;

import earlyacces_source.Virologist;

public interface Visitable {

    boolean acceptVisitor(CollectibleVisitor visitor, Virologist v);
}
