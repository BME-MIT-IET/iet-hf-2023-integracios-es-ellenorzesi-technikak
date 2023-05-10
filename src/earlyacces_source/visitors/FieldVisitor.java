package earlyacces_source.visitors;

import earlyacces_source.Virologist;
import earlyacces_source.field.FreeField;
import earlyacces_source.field.Laboratory;
import earlyacces_source.field.Shelter;
import earlyacces_source.field.Storage;

public interface FieldVisitor {
    boolean visit(Storage s, Virologist v);
    boolean visit(FreeField f, Virologist v);
    boolean visit(Shelter s, Virologist v);
    boolean visit(Laboratory l, Virologist v);
}
