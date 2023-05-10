package earlyacces_source.code;

import earlyacces_source.*;
import earlyacces_source.state.Dancing;

import java.io.Serializable;

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
