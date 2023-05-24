package hu.bme.iet_hf_group.wizard.earlyacces_source.code;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Dancing;

/**
 * Vitustáncoltató ágens létrehozásához szükséges genetikai kód
 * */
public class Chorea extends Code  {
	/**
	 * Vitustánc kifejtése a paraméterül kapott virológuson
	 * @param v Az a virológus, akire a hatás kifejtődik
	 * */
	public void setState(Virologist v) {
		v.addState(new Dancing());
	}
}
