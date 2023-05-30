package hu.bme.iet_hf_group.wizard.earlyacces_source.visitors;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.FreeField;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Laboratory;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Storage;

public interface FieldVisitor {
    boolean visit(Storage s, Virologist v);
    boolean visit(FreeField f, Virologist v);
    boolean visit(Shelter s, Virologist v);
    boolean visit(Laboratory l, Virologist v);
}
