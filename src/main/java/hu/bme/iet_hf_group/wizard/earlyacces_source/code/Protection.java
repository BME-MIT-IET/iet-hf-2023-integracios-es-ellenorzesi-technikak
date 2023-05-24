package hu.bme.iet_hf_group.wizard.earlyacces_source.code;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Immune;

/**
 * Védő ágens létrehozásához szükséges genetikai kód
 * */
public class Protection extends Code {
	/**
	 * Védelem kifejtése a paraméterül kapott virológuson
	 * @param v Az a virológus, akire a hatás kifejtődik
	 * */
	public void setState(Virologist v) {
		v.addState(new Immune());
	}
}
