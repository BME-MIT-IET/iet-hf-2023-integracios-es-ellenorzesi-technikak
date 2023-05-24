package earlyacces_source.state;

/**
 * A virológus állapota, sikeres “Protection” ágens kenés után
 * */
public class Immune extends State{
	/**
	 * Az immunis állapot hatását valósítja meg
	 * @return Visszatér, hogy él-e még az állapot
	 */
	public boolean Do() {
		this.timeLeft--;
		if(this.timeLeft <= 0)
			return false;
		return true;
	}

	/**
	 * Kezeli a további állapotok beállítását
	 * @return Visszaadja, hogy immunis-e az adott virológius
	 */
	@Override
	public boolean action() {
		return true;
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
		return true;
	}

	public boolean strongerThan(Dancing other) {
		return true;
	}

	public boolean strongerThan(Default other) {
		return true;
	}
}
