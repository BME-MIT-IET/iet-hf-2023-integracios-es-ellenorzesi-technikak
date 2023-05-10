package earlyacces_source.state;

/**
 * A virológus alapállapota
 * */
public class Default extends State {
	/**
	 * Konstruktor
	 * */
	public Default() {
		timeLeft = 0;
	}

	/**
	 * Az alapállapot hatását valósítja meg
	 * @return Visszatér, hogy él-e még az állapot
	 */
	public boolean Do() {
		return true;
	}

	public boolean strongerThan(State other) {
		return other.strongerThan(this);
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
}
