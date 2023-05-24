package hu.bme.iet_hf_group.wizard.earlyacces_source.field;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Collectible;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.FieldVisitor;
import hu.bme.iet_hf_group.wizard.graphics.FieldColourVisitor;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Ez az absztrakt osztály valósítja meg a pályán található mezőket
 * */
public abstract class Field implements Serializable {
	protected List<Virologist> virologists;
	protected List<Field> neighbours;

	/**
	 * Konstruktor
	 * */
	public Field() {
		virologists = new ArrayList<Virologist>();
		neighbours = new ArrayList<Field>();
	}

	/**
	 * Ez a metódus hívódik meg, ha a virológus átlép erre a mezőre
	 * @param v	A lépést végrehajtó virológus
	 * @return A lépés sikeressége
	 * */
	public boolean accept(Virologist v) {
		if (v != null) {
			virologists.add(v);
		}
		return true;
	}

	/**
	 * Ha a virológus sikeresen átlépett egy másik mezőre, akkor ez a metódus törli le az előzőről
	 * @param v	A törlendő virológus
	 * */
	public void remove(Virologist v) {
		if (v != null) {
			virologists.remove(v);
		}
	}

	/**
	 * Pályagenerálás, ezzel a metódussal alakulnak ki a szomszédságok a mezők között
	 * @param f A szomszédos mező
	 * */
	public void addNeighbourField(Field f) {
		if (f != null) {
			neighbours.add(f);
		}
	}

	/**
	 * Az aktuális mezőt átkutatja gyűjthető tárgyak, anyagok után
	 * @param v A kutató virológus
	 * */
	public abstract boolean collect(Virologist v);

	/**
	 * Az elhasznált, vagy eldobott dolgokat törli, és újat hoz létre a helyére
	 * @param c Az elhasznált dolog
	 * */
	public void removeItem(Collectible c) {
		return;
	}

	public boolean acceptVisitor(FieldVisitor visitor, Virologist v) {
		return false;
	}

	public Color acceptColorVisitor(FieldColourVisitor fieldColourVisitor) {
		return fieldColourVisitor.visit(this);
	}

	/**
	 * GETTERS SETTERS
	 */

	public List<Field> getNeighbours() {
		return neighbours;
	}

	public List<Virologist> getVirologists() {
		return virologists;
	}

    public void Print() {
    }
}