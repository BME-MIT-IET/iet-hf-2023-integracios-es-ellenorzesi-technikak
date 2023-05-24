package earlyacces_source.field;

import earlyacces_source.*;
import earlyacces_source.gameCore.Round_Manager;
import earlyacces_source.visitors.CollectibleVisitor;
import earlyacces_source.visitors.FieldVisitor;
import graphics.FieldColourVisitor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Az raktár megvalósítása
 */
public class Storage extends Field {
	/**
	 * A tárolt anyagok listája
	 */
	private List<Material> storedMaterials;

	/**
	 * Konstruktor
	 * */
	public Storage() {
		storedMaterials= new ArrayList<Material>();

		/** Random mennyiségű anyag generálása */
		Random random = new Random();
		for (int i = random.nextInt(5) + 1; i > 0; i--) {
			Material m = new Material();
			m.setBaseField(this);
			storedMaterials.add(m);
		}
	}

	/**
	 * Ha van anyag a raktárban, akkor a paraméterül kapott v virológus ezt felveszi
	 * @param v Az a virológus, amelyik felveszi az anyagot
	 */
	@Override
	public boolean collect(Virologist v) {
		if(!storedMaterials.isEmpty()) {
			storedMaterials.get(0).collect(v);
			return true;
		}else{
			return false;
		}
	}

	/**
	 * A paraméterül kapott anyagot törli a raktár listájából
	 * @param c A törlendő anyag
	 */
	@Override
	public void removeItem(Collectible c) {
		if (storedMaterials.contains(c)) {
			storedMaterials.remove(c);
		}
	}

	@Override
	public boolean acceptVisitor(FieldVisitor visitor, Virologist v) {
		return visitor.visit(this, v);
	}

	@Override
	public Color acceptColorVisitor(FieldColourVisitor fieldColourVisitor) {
		return fieldColourVisitor.visit(this);
	}

	public int getMaterialCount(){
		return storedMaterials.size();
	}
}
