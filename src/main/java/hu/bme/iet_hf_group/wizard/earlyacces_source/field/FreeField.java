package hu.bme.iet_hf_group.wizard.earlyacces_source.field;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.FieldVisitor;
import hu.bme.iet_hf_group.wizard.graphics.FieldColourVisitor;

import java.awt.*;

/**
 * Szabad mező, amely nem tartalmaz gyűjthető tárgyakat és anyagokat
 * */
public class FreeField extends Field {
	/**
	 * Az aktuális mezőt átkutatja gyűjthető tárgyak, anyagok után		// NEM KÉNE FELESLEGESEN MEGVALÓSÍTANI, ELÉG LENNE A TÖBBI HELYEN FELÜLÍRNI
	 * @param v A kutató virológus
	 */
	public boolean collect(Virologist v) {
		return false;
	}

	/**
	 *
	 * @param visitor Fieldek különböztetésére
	 * @param v Virológus
	 * @return visitor- milyen mező
	 */
	@Override
	public boolean acceptVisitor(FieldVisitor visitor, Virologist v) {
		return visitor.visit(this, v);
	}

	/**
	 *
	 * @param fieldColourVisitor Fieldek színének különböztetésére
	 * @return visitor- milyen színű
	 */
	@Override
	public Color acceptColorVisitor(FieldColourVisitor fieldColourVisitor) {
		return fieldColourVisitor.visit(this);
	}
}