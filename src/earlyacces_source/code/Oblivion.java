package earlyacces_source.code;

import earlyacces_source.*;

import java.util.ArrayList;

/**
 * Felejtő ágens létrehozásához szükséges genetikai kód
 * */
public class Oblivion extends Code {
	/**
	 * A paraméterül kapott virológus kódjainak törlése
	 * @param v Az a virológus, akire a hatás kifejtődik
	 * */
	public void setState(Virologist v) {
		v.setCodes(new ArrayList<Code>());
	}
}
