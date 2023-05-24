package earlyacces_source;

import earlyacces_source.field.*;
import earlyacces_source.visitors.Visitable;
import earlyacces_source.visitors.addCollectibleVisitor;

import java.io.Serializable;

/**
 * Gyűjthető dolgok absztrakt ősosztálya
 * */
public abstract class Collectible implements Visitable, Serializable {
	/**
	 * A játék kezdetén erre a mezőre generálódik a gyűjthető dolog
	 * */
	protected Field baseField;

	/**
	 * A gyűjthető dolgot odaadja a virológusnak
	 * @param v Az a virológus, akihez kerül a gyűjthető dolog
	 * */
	public abstract boolean collect(Virologist v);

	/**
	 * GETTERS SETTERS
	 */

	public Field getBaseField() {
		return baseField;
	}

	public void setBaseField(Field f) {
		baseField = f;
	}
}
