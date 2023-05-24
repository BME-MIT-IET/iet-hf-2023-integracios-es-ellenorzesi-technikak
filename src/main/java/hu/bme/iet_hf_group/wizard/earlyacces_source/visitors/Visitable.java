package hu.bme.iet_hf_group.wizard.earlyacces_source.visitors;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;

public interface Visitable {

    boolean acceptVisitor(CollectibleVisitor visitor, Virologist v);
}
