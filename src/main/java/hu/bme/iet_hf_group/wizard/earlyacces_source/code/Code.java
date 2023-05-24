package hu.bme.iet_hf_group.wizard.earlyacces_source.code;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Collectible;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.CollectibleVisitor;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A genetikai kódok absztrakt ősosztálya
 * */
public abstract class Code extends Collectible {
	/**
	 * A genetikai kód felhasználásához szükséges Material
	 * */
	protected ArrayList<Material> neededMaterials = new ArrayList<>(Arrays.asList(new Material()));
	
	/**
	 * A genetikai kód hatásának kifejtése a paraméterül kapott virológuson
	 * @param v Az a virológus, akire a hatás kifejtődik
	 * */
	public abstract void setState(Virologist v);
	
	/**
	 * Védekezés az azonos típusú genetikai kódok ellen
	 * @param c Az a genetikai kód, amelyik ellen védekezünk
	 * @return A védekezés sikeressége
	 * */
	public boolean vaccinate(Code c) {
		if (this == c) {
			return true;
		}
		return false;
	}

	/**
	 * A kódot odaadja a virológusnak
	 * @param v Az a virológus, akihez kerül a kód
	 * */
	@Override
	public boolean collect(Virologist v) {
		return v.add(this);
	}

	/**
	 * Visitoroknak segít
	 * @param visitor Gyűjthető visitor
	 * @param v Virológus
	 * @return Visitor
	 */
	@Override
	public boolean acceptVisitor(CollectibleVisitor visitor, Virologist v) {
		return visitor.visit(this, v);
	}

	/**
	 * Materialszükség beállítása
	 * @param neededMaterials kelőő material
	 */
	public void setNeededMaterials(ArrayList<Material> neededMaterials) {
		this.neededMaterials = neededMaterials;
	}

	/**
	 * @return A példány egyedi azonosítója.
	 */
	public String ToString() {
		return getClass().getSimpleName();
	}
}
