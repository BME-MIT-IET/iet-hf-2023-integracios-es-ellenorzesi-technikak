package earlyacces_source.state;

import earlyacces_source.*;
import earlyacces_source.field.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 	PRIORITÁS: BEAR > IMMUNE > PARALYSING > DANCING > DEFAULT
 */

/**
 * A virológus állapotát leíró absztrakt ősosztály
 * */
public abstract class State implements Serializable {

	/**
	 * Azt jelzi meddig marad az adott állapotban a virológus
	 * */
	protected int timeLeft = 5;

	/**
	 * Absztrakt függvény, mely az adott állapot hatását valósítja meg
	 * */
	public abstract boolean Do();
	
	/**
	 * A virológus megfelelő állapotban történő másik mezőre való lépéséért felelős
	 * */
	public void move(Virologist v, Field f) {
		if (f.accept(v)) {
			v.getField().remove(v);
			v.setField(f);
		}
	}
	
	/**
	 * A rablást kezeli le az állapot függvényében
	 * @param v Az a virológus, akit ki akarnak rabolni
	 * @return Visszatér az elvehető dolgokkal
	 * */
	public ArrayList<Collectible> robAction(Virologist v) {
		return null;
	}
	
	/**
	 * Kezeli a további állapotok beállítását
	 * */
	public boolean action() {
		return false;
	}


	public boolean strongerThan(State other) {
		return other.strongerThan(this);
	}

	public boolean strongerThan(Bear other) {
		return false;
	}

	public boolean strongerThan(Immune other) {
		return false;
	}

	public boolean strongerThan(Paralysed other) {
		return false;
	}

	public boolean strongerThan(Dancing other) {
		return false;
	}

	public boolean strongerThan(Default other) {
		return false;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	/**
	 * @return A példány egyedi azonosítója.
	 */
	public String ToString() {
		return getClass().getSimpleName() + ": " + String.format("%03d", timeLeft);
	}
}
