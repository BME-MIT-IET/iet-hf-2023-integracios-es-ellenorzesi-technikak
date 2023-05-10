package earlyacces_source.code;

import earlyacces_source.*;
import earlyacces_source.state.Paralysed;

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
