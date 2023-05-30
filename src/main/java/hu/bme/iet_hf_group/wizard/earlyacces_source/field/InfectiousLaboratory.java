package hu.bme.iet_hf_group.wizard.earlyacces_source.field;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.BearVirus;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.FieldVisitor;
import hu.bme.iet_hf_group.wizard.graphics.FieldColourVisitor;

import java.awt.*;

/**
 * Fertőző laboratórium mező, amely pontosan egy genetikai kódot tartalmaz
 * */
public class InfectiousLaboratory extends Laboratory {
    /**
     * Konstruktor
     * @param code A laboratóriumban elhelyezendő genetikai kód
     * */
    public InfectiousLaboratory(Code code) {
        super(code);
    }

    /**
     * Ez a metódus hívódik meg, ha a virológus átlép erre a mezőre
     * @param v	A lépést végrehajtó virológus
     * @return A lépés sikeressége
     * */
    @Override
    public boolean accept(Virologist v) {
        v.getEffected(new BearVirus());
        return super.accept(v);
    }

    @Override
    public boolean acceptVisitor(FieldVisitor visitor, Virologist v) {
        return visitor.visit(this, v);
    }

    @Override
    public Color acceptColorVisitor(FieldColourVisitor fieldColourVisitor) {
        return fieldColourVisitor.visit(this);
    }
}
