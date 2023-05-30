package hu.bme.iet_hf_group.wizard.earlyacces_source.gear;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Collectible;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.CollectibleVisitor;

/**
 * A virológusok által felvehető védőfelszerelések absztrakt ősosztálya
 */
public abstract class Gear extends Collectible {
	/**
	 * Hány használatig érvényes az adott felszerelés
	 */
	protected int counter;

	/**
	 * A felszerelés felhasználása
	 * @param def A védekező virológus
	 * @param atk A kezdeményező virológus
	 * @param c A támadáshoz használt kód
	 * @return Visszatér azzal, hogy sikeres volt-e támadás
	 */
	public boolean use(Virologist def, Virologist atk, Code c) {
		return false;
	}

	/**
	 * Visitoroknak segít
	 * @param visitor - gyűjthető visitor
	 * @param v Virológus
	 * @return Visitor
	 */
	@Override
	public boolean acceptVisitor(CollectibleVisitor visitor, Virologist v) {
		return visitor.visit(this, v);
	}

	/**
	 * @return A példány egyedi azonosítója.
	 */
	public String ToString() {
		return getClass().getSimpleName() + ": " + counter;
	}
	/**
	 * A köpenyt odaadja a virológusnak
	 * @param v Az a virológus, akihez kerül a gyűjthető dolog
	 */
	@Override
	public boolean collect(Virologist v) {
		if (v.add(this)) {
			baseField.removeItem(this);
			return true;
		}
		return false;
	}

	/**
	 * Törlő metódus absztrakt
	 * @param v Virológus
	 */
	public void remove(Virologist v) { }


	public int getCounter() {
		return counter;
	}
}
