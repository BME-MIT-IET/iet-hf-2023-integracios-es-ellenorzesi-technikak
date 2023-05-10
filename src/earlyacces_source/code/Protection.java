package earlyacces_source.code;

import earlyacces_source.*;
import earlyacces_source.state.Immune;

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
