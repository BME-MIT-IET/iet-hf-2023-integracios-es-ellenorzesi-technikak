package earlyacces_source.field;

import earlyacces_source.*;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.visitors.CollectibleVisitor;
import earlyacces_source.visitors.FieldVisitor;
import graphics.FieldColourVisitor;

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