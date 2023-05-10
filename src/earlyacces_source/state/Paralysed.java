package earlyacces_source.state;

import earlyacces_source.*;
import earlyacces_source.field.*;

import java.util.ArrayList;

/**
 * A virológus állapota, miután sikeresen lebénították
 * */
public class Paralysed extends State {
	/**
	 * A bénult állapot hatását valósítja meg
	 * @return Visszatér, hogy él-e még az állapot
	 */
	public boolean Do() {
		this.timeLeft--;
		if(this.timeLeft <= 0)
			return false;
		return true;
	}
	
	/**
	 * A virológus ebben az állapotban nem tud lépni
	 * */
	@Override
	public void move(Virologist v, Field f) { return; }
	
	/**
	 * A rablást kezeli le a az állapot függvényében
	 * @param v Az a virológus, akit kirabolnak
     * @return Visszatér az elvehető dolgokkal
	 * */
	@Override
	public ArrayList<Collectible> robAction(Virologist v) {
		ArrayList<Collectible> back = new ArrayList<Collectible>();
		if(v.getGears().size() > 0)
			back.addAll(v.getGears());
		if (v.getMaterials().size() > 0)
			back.addAll(v.getMaterials());
		return back;
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
		return true;
	}

	public boolean strongerThan(Default other) {
		return true;
	}
}
