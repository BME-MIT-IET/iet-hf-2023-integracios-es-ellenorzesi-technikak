package hu.bme.iet_hf_group.wizard.earlyacces_source.field;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.FieldVisitor;
import hu.bme.iet_hf_group.wizard.graphics.FieldColourVisitor;

import java.awt.*;

/**
 * Laboratórium mező, amely pontosan egy genetikai kódot tartalmaz
 * */
public class Laboratory extends Field {
	/**
	 * Genetikai kód
	 * */
	private Code code;

	/**
	 * Konstruktor
	 * @param c A laboratóriumban elhelyezendő genetikai kód
	 * */
	public Laboratory(Code c) {
		code = c;
	}

	/**
	 * Ezzel a metódussal lehet a laboratórium mezőn genetikai kódot szerezni
	 * @param v A genetiaki kódot kutató virológus
	 * */
	public boolean collect(Virologist v) {
		if (v != null) {
			code.collect(v);
			return true;
		}
		return false;
	}

	/**
	 * Visitoroknak segít
	 * @param visitor Mezővisitor
	 * @param v Virológus
	 * @return visitor
	 */
	@Override
	public boolean acceptVisitor(FieldVisitor visitor, Virologist v) {
		return visitor.visit(this, v);
	}

	/**
	 * Visitor színezésben
	 * @param fieldColourVisitor Mezőszín vizitor
	 * @return visitor
	 */
	@Override
	public Color acceptColorVisitor(FieldColourVisitor fieldColourVisitor) {
		return fieldColourVisitor.visit(this);
	}


}