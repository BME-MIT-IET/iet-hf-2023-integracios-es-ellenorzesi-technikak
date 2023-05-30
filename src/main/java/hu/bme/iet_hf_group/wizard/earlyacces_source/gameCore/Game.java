package hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore;

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Játék osztály
 * */
public class Game implements Serializable {
	private static final long serialVersionUID = -3034961113989118150L;
	/**
	 * A game-ből egy példány létezik a játékban, singleton
	 */
	private static Game gameSingleton = null;

	private Virologist winner;

	/**
	 * Konstruktor
	 * */
	private Game() {
		winner = null;
	}

	/**
	 * Új játék indítása
	 */
	public void newGame(int numberOfPlayers) {
		Round_Manager.getInstance().startGame(numberOfPlayers);
	}

	/**
	 * Mentett játékállás betöltése
	 */
	public void loadGame() throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream("Core.dat");
		ObjectInputStream in =new ObjectInputStream(f);
		List<Object>l= (List<Object>)in.readObject();

		Game.SetInstance((Game) l.get(0));
		Round_Manager.setInstance((Round_Manager) l.get(1));

		in.close();
	}

	public void saveGame() throws IOException {
		List<Object> l= new ArrayList<Object>();
		l.add(Game.getInstance());
		l.add(Round_Manager.getInstance());
		FileOutputStream f = new FileOutputStream( "Core.dat");
		ObjectOutputStream out =new ObjectOutputStream(f);
		out.writeObject(l);
		out.close();
	}

	/**
	 * Bezárja a játékot
	 */
	public void endGame() {
		winner = Round_Manager.getInstance().getCurrentVirologist();
	}


	/**
	 * GETTERS SETTERS
	 */

	/**
	 * A singleton Game példány elérése / létrehozása
	 * @return A singleton Game példány
	 */
	public static Game getInstance() {
		if (gameSingleton == null)
			gameSingleton = new Game();
		return gameSingleton;
	}

	public static void SetInstance(Game g){
		gameSingleton=g;
	}

	public Virologist getWinner() {
		return winner;
	}
}
