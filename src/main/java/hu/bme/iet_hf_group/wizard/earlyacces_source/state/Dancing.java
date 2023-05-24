package hu.bme.iet_hf_group.wizard.earlyacces_source.state;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.Field;

import java.util.Random;

/**
 * A virológus állapota, miután sikeresen megtáncoltatták
 * */
public class Dancing extends State {
	/**
	 * Az vitustánc állapot hatását valósítja meg
	 * @return Visszatér, hogy él-e még az állapot
	 */
	public boolean Do() {
		this.timeLeft--;
		if(this.timeLeft <= 0)
			return false;
		return true;
	}

	/**
	 * A virológus megfelelő állapotban történő másik mezőre való lépéséért felelős. Ebben az állapotban random lép
	 * @param v Az a virológus, aki lép
	 * @param f Az a mező, ahova lépünk
	 */
	@Override
	public void move(Virologist v, Field f) {
		Random rand = new Random();
		if (v.getField().getNeighbours().size() > 0) {
			int rnd = rand.nextInt(v.getField().getNeighbours().size());
			Field next = v.getField().getNeighbours().get(rnd);
			if (next.accept(v)) {
				v.getField().remove(v);
				v.setField(next);
			}
		}
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
		return true;
	}
}
