package hu.bme.iet_hf_group.wizard.earlyacces_source.visitors;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.FreeField;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Laboratory;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Shelter;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Storage;

public class bearVisitor implements FieldVisitor {

    @Override
    public boolean visit(Storage s, Virologist v) {
        while (s.collect(v)) {
            v.delete(v.getMaterial());
        }
        return true;
    }

    @Override
    public boolean visit(FreeField f, Virologist v) {return false;}

    @Override
    public boolean visit(Shelter s, Virologist v) {return false;}

    @Override
    public boolean visit(Laboratory l, Virologist v) {return false;}
}
