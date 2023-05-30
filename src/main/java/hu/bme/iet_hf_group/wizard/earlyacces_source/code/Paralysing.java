package hu.bme.iet_hf_group.wizard.earlyacces_source.code;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Paralysed;

/**
 * Bénító ágens létrehozásához szükséges genetikai kód
 * */
public class Paralysing extends Code {
	/**
	 * Bénító hatás kifejtése a paraméterül kapott virológuson
	 * @param v Az a virológus, akire a hatás kifejtődik
	 * */
	public void setState(Virologist v) {
		v.addState(new Paralysed());
	}
}
