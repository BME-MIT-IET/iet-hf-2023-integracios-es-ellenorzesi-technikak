package earlyacces_source.field;

import earlyacces_source.Collectible;
import earlyacces_source.Virologist;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.gear.Gear;
import earlyacces_source.visitors.FieldVisitor;
import graphics.FieldColourVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Az óvóhely megvalósítása
 */
public class Shelter extends Field {
	private List<Gear> gears;

	/**
	 * Konstruktor
	 * */
	public Shelter(){
		gears = new ArrayList<Gear>();
	}

	/**
	 * Ha az óvóhelyen van felszerelés akkor ezt a v virológus felveheti
	 * @param v Az a virológus, amelyik felveszi az felszerelést
	 */
	@Override
	public boolean collect(Virologist v) {
		if(!gears.isEmpty()) {
			gears.get(0).collect(v);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * A paraméterül kapott felszerelést törli az óvóhely listájáról
	 * @param c A törlendő felszerelés
	 */
	@Override
	public void removeItem(Collectible c) {
		if(!gears.isEmpty())
			gears.remove(c);
	}


	/**
	 * GETTERS SETTERS
	 */

	public void addGear(Gear gear) {
		gears.add(gear);
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
