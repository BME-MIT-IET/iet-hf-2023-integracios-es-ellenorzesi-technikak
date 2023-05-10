package earlyacces_source.gear;

import earlyacces_source.*;
import earlyacces_source.code.*;

import java.util.Random;

/**
 * A virológus által felvehető köpeny osztálya
 */
public class Cape extends Gear {
	/**
	 * Konstruktor
	 * */
	public Cape(){
		counter = 1;
	}

	/**
	 * 82.3%-os hatásfokkal rendelkező védekező eszköz használatát megvalósító függvény
	 * @param def A védekező virológus
	 * @param atk A kezdeményező virológus
	 * @param c A támadáshoz használt kód
	 * @return Visszatér azzal, hogy sikeres volt-e támadás
	 */
	public boolean use(Virologist def, Virologist atk, Code c) {
		if (c == null) {
			return false;
		}
		if (counter-- > 0) {
			Random rand= new Random();
			if (rand.nextInt(1000) <= 823) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
