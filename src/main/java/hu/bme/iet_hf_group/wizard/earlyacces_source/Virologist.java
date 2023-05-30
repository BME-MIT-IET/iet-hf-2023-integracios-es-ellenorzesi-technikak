package hu.bme.iet_hf_group.wizard.earlyacces_source;

import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Field;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Gear;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Default;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.State;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.addCollectibleVisitor;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.deleteCollectibleVisitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A játékos által irányított virológus
 */
public class  Virologist implements Serializable {
	/**
	 * Az anyagok maximális mennyisége
	 */
	private int maxMaterial;
	/**
	 * A virológus felszerelései
	 */
	private List<Gear> gears;
	/**
	 * A virológus által megtanult kódok
	 */
	private List<Code> codes;
	/**
	 * A virológus anyagai
	 */
	private List<Material> materials;
	/**
	 * A virológus állapotai
	 */
	private LinkedList<State> states;
	/**
	 * Az a mező, amelyiken a virológus áll
	 */
	private Field field;

	/**
	 * Konstruktor
	 * */
	public Virologist() {
		gears=new ArrayList<Gear>();
		codes=new ArrayList<Code>();
		materials=new ArrayList<Material>();
		states=new LinkedList<State>();

		Default d = new Default();
		states.add(d);
		maxMaterial = 3;
	}

	/**
	 * Egy védőfelszerelést ad a virológus tárhelyéhez
	 * @param g A kapott védőfelszerelés
	 * @return A tárolás sikeressége
	 */
	public boolean add(Gear g) {
		if(!gears.contains(g) && gears.size() <= 3) {
			gears.add(g);
			return true;
		}
		return false;
	}

	/**
	 * Egy genetikai kódot ad a virológus tárhelyéhez
	 * @param c A kapott genetikai kód
	 * @return A tárolás sikeressége
	 */
	public boolean add(Code c) {
		if(!codes.contains(c)) {
			codes.add(c);
			return true;
		}
		return false;
	}

	/**
	 * Egy anyagot ad a virológus tárhelyéhez
	 * @param m A kapott anyag
	 * @return A tárolás sikeressége
	 */
	public boolean add(Material m) {
		if(materials.size() < maxMaterial) {
			materials.add(m);
			return true;
		}
		return false;
	}

	/**
	 * Material törlése az inventoryból
	 * @param m törlendő material
	 */
	public void delete(Material m) {
		if (m == null)
			return;
		materials.remove(m);
	}

	/**
	 *  Gear törlése az inventoryból
	 * @param g törlendő Gear
	 */
	public void delete(Gear g) {
		if (g == null)
			return;
		gears.remove(g);
	}

	/**
	 * Code tölése az Inventoryból
	 * @param c törlendő kód
	 */
	public void delete(Code c) {
		if (c == null)
			return;
		codes.remove(c);
	}

	/**
	 * Ágens hatásának kifejtése
	 * @param c Az a kód, amely kifejti hatását
	 * @param v Az a virológus, akin a hatás kifejtődik
	 */
	public void getEffected(Code c, Virologist v) {
		if (states.get(0).action())
			return;
		for (Gear g: gears) {
			if (g.use(this, v, c)) {
				if (g.getCounter() <= 0)
					gears.remove(g);
				return;
			}
		}
		for (Code code: codes) {
			if (materials.size() > 0 && code.vaccinate(c)) {
				getMaterial().acceptVisitor(new deleteCollectibleVisitor(), this);
				return;
			}
		}
		c.setState(this);
	}

	/**
	 * Ágens hatásának kifejtése
	 * @param c Az a kód, amely kifejti hatását
	 */
	public void getEffected(Code c) {
		if (states.get(0).action())
			return;
		c.setState(this);
	}

	/**
	 * Virologus kirablása
	 * @param v Az a virológus, aki a rablást kezdeményezte
	 * @return A virológustól elrabolható dolgok
	 */
	public List<Collectible> getRobbed(Virologist v) {
		//todo statek prio
		return states.get(0).robAction(this);
	}

	/**
	 * Lépés a paraméternek kapott mezőre
	 * @param f Az a mező, ahova lépni szeretnénk
	 */
	 public void move(Field f) {
		if(f!=field)
		 	states.get(0).move(this, f);
	 }

	 /**
	 * Virológus kirablása
	 * @param v Az a virológus, akit ki szeretnénk rabolni
	 */
	public void rob(Virologist v) {
		if (v == null) return;
		List<Collectible> items = v.getRobbed(this);
		if (items != null && items.size() > 0) {
			if (items.get(0).acceptVisitor(new addCollectibleVisitor(), this)) {
				items.get(0).acceptVisitor(new deleteCollectibleVisitor(), v);
			}
		}
	}

	/**
	 * Az aktuális mezőt átkutatja gyűjthető tárgyak, anyagok után
	 */
	public void searchField() {
		field.collect(this);
	}

	/**
	 * A virológus állapotát megváltoztató metódus
	 * @param s Új állapot
	 */
	public void addState(State s) {
		boolean ok = false;
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i).strongerThan(s)) {
				if (i == 0)
					states.addFirst(s);
				else
					states.add(states.indexOf(states.get(i)), s);
				ok = true;
				break;
			}
		}
		if(!ok){
			states.add(states.size() - 2, s);
		}
	}

	/**
	 * Ágens használata egy virológuson
	 * @param c Az a kód, amit felhasználunk
	 * @param v Az a virológus, akin a hatás kifejtődik
	 */
	public void useCode(Code c, Virologist v) {
		if (materials.size() > 0) {
			(materials.get(materials.size() - 1)).acceptVisitor(new deleteCollectibleVisitor(), this);
			v.getEffected(c, this);
		}
	}

	/**
	 * Állapot törlése
	 * @param s A törlendő állapot
	 */
	public void removeState(State s) {
		if(!states.isEmpty())
			states.remove(s);
		if(states.isEmpty())
			states.add(new Default());
	}

	/**
	 * Felszerelés használata. (pl. támadásra)
	 * @param v Az a virológus, akin használjuk a felszereléset.
	 */
	public void useGear(Virologist v) {
		for (Gear g : gears)
			if (g.use(v, this, null)) break;
	}

	/**
	 * GETTERS SETTERS
	 */

	public int getMaxMaterial() {
		return maxMaterial;
	}

	public void setMaxMaterial(int newMaxMaterial) {
		if(newMaxMaterial < 0)
			maxMaterial = 0;
		maxMaterial = newMaxMaterial;
		while (materials.size() > maxMaterial) {
			materials.remove(materials.size() - 1);
		}
	}

    public void setCodes(List<Code> codes) {
		this.codes = codes;
	}

	public List<Code> getCodes() {
		return codes;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public Field getField() {
		return field;
	}

	public List<Gear> getGears() {
		return gears;
	}

	public Material getMaterial() {
		if (materials.size() > 0)
			return materials.get(materials.size()-1);
		return null;
	}

	public LinkedList<State> getStates() {
		return states;
	}

    public void Print() {
    }
}
