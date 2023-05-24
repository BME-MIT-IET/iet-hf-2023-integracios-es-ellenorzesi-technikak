package hu.bme.iet_hf_group.wizard.earlyacces_source.gear;


import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.code.Code;

/**
 * A virológus által felvehető kesztyű osztálya
 */
public class Glove extends Gear {
	/**
	 * Konstruktor
	 * */
	public Glove(){
		counter = 3;
	}

	/**
	 * A kesztyű használata
	 * @param def A kezdeményező virológus
	 * @param atk A támadott virológus
	 * @param c A támadáshoz használt kód
	 * @return Visszatér azzal, hogy sikeres volt-e támadás
	 */
	@Override
	public boolean use(Virologist def, Virologist atk, Code c) {
		if (c == null) {
			return false;
		}
		if (counter-- > 0) {
			atk.getEffected(c, def);
			return true;
		}
		else {
			return false;
		}
	}
}
