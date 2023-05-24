package hu.bme.iet_hf_group.wizard.earlyacces_source.gear;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.CollectibleVisitor;

/**
 * A virológus által felvehető zsák osztálya
 */
public class Bag extends Gear {
	/**
	 * A zsák mérete
	 */
	private int size;

	/**
	 * Konstruktor
	 * */
	public Bag(){
		counter = -1;
		size = 3;
	}

	/**
	 * A zsákot odaadja a virológusnak
	 * @param v Az a virológus, akihez kerül a zsák
	 */
	@Override
	public boolean collect(Virologist v) {
		if(v.add(this)) {
			baseField.removeItem(this);
			v.setMaxMaterial(v.getMaxMaterial() + size);
			return true;
		}
		return false;
	}

	@Override
	public void remove(Virologist v) {
		v.setMaxMaterial(v.getMaxMaterial() - size);
	}

	@Override
	public boolean acceptVisitor(CollectibleVisitor visitor, Virologist v) {
		return visitor.visit(this, v);
	}
}
