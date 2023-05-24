package hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore;//

import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;

import hu.bme.iet_hf_group.wizard.earlyacces_source.code.*;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.*;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Axe;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Bag;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Cape;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Glove;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.State;

import java.io.Serializable;
import java.util.*;

/**
 * Játékvezérlő osztály
 * */
public class Round_Manager implements Serializable {
	private static Round_Manager roundManagerSingleton = null;
	private static final long serialVersionUID = 5111427126786610552L;

	public String getVirologistsName(Virologist virologist) {
		return SearchKeyWithValue(virologists, virologist);
	}

	public Virologist getVirologist(String name) {
		return virologists.get(name);
	}

	public String getFieldName(Field field) {
		return SearchKeyWithValue(fields, field);
	}

	public Field getField(String name) {
		return fields.get(name);
	}

	public void addVirologists(String name, Virologist virologist) {
		virologists.put(name, virologist);
		virologistOrder.add(virologist);
	}

	public void addField(String name, Field field) {
		fields.put(name, field);
		fields2.add(field);
	}

	public void addCode(Code code) {
		codes.add(code);
	}

	public HashMap<String, Virologist> getVirologists() {
		return virologists;
	}

	private HashMap<String, Virologist> virologists;
	private HashMap<String, Field> fields;
	private HashSet<Code> codes;
	private List<State> playerStates;
	private int round;
	private LinkedList<Virologist> virologistOrder;
	private LinkedList<Field> fields2;

	public int getNumberOfPlayer() {
		return virologists.size();
	}

	public LinkedList<Field> getFields() {
		return fields2;
	}

	/**
	 * Konstruktor
	 */
	private Round_Manager(int number) {
		virologists = new HashMap<String, Virologist>();
		fields = new HashMap<String, Field>();
		codes = new HashSet<Code>();
		playerStates = new ArrayList<>();
		round = 1;
		virologistOrder = new LinkedList<Virologist>();
		fields2 = new LinkedList<Field>();
	}

	/**
	 * Új játék indítása
	 * @param numberOfPlayers Játékosok száma
	 */
	public void startGame(int numberOfPlayers) {
		if (numberOfPlayers < 1) numberOfPlayers = 1;
		virologists.clear();
		fields.clear();
		codes.clear();
		playerStates.clear();
		round = 1;
		virologistOrder.clear();
		fields2.clear();

		Random rnd = new Random();
		Chorea chorea = new Chorea();
		Oblivion oblivion = new Oblivion();
		Protection protection = new Protection();
		Paralysing paralysing = new Paralysing();
		for (int i = 0; i < 50; i++) {
			int percent = rnd.nextInt(100);
			if (percent < 15) {
				int codePercent = rnd.nextInt(100);
				if (codePercent < 25) {
					fields2.add(new Laboratory(chorea));
					codes.add(chorea);
				} else if (codePercent < 50) {
					fields2.add(new Laboratory(oblivion));
					codes.add(oblivion);
				} else if (codePercent < 75) {
					fields2.add(new Laboratory(protection));
					codes.add(protection);
				} else {
					fields2.add(new Laboratory(paralysing));
					codes.add(paralysing);
				}
			} else if (percent < 20) {
				int codePercent = rnd.nextInt(100);
				if (codePercent < 25) {
					fields2.add(new InfectiousLaboratory(chorea));
					codes.add(chorea);
				} else if (codePercent < 50) {
					fields2.add(new InfectiousLaboratory(oblivion));
					codes.add(oblivion);
				} else if (codePercent < 75) {
					fields2.add(new InfectiousLaboratory(protection));
					codes.add(protection);
				} else {
					fields2.add(new InfectiousLaboratory(paralysing));
					codes.add(paralysing);
				}
			} else if (percent < 40) {
				int gearPercent = rnd.nextInt(100);
				if (gearPercent < 100) {
					Shelter s = new Shelter();
					fields2.add(s);
					for (int j = 0; j < rnd.nextInt(20) + 1; j++) {
						Glove g = new Glove();
						g.setBaseField(s);
						s.addGear(g);
					}
				} else if (gearPercent < 50) {
					Shelter s = new Shelter();
					fields2.add(s);
					for (int j = 0; j < rnd.nextInt(20) + 1; j++) {
						Cape c = new Cape();
						c.setBaseField(s);
						s.addGear(c);
					}
				} else if (gearPercent < 75) {
					Shelter s = new Shelter();
					fields2.add(s);
					for (int j = 0; j < rnd.nextInt(20) + 1; j++) {
						Bag b = new Bag();
						b.setBaseField(s);
						s.addGear(b);
					}
				} else {
					Shelter s = new Shelter();
					fields2.add(s);
					for (int j = 0; j < rnd.nextInt(20) + 1; j++) {
						Axe a = new Axe();
						a.setBaseField(s);
						s.addGear(a);
					}
				}
			} else if (percent < 70) {
				fields2.add(new Storage());
			} else {
				fields2.add(new FreeField());
			}
		}
		for (int i = 0; i < numberOfPlayers; i++) {
			Virologist v = new Virologist();
			int index = rnd.nextInt(50);
			fields2.get(index).accept(v);
			v.setField(fields2.get(index));
			virologists.put("v" + (i + 1), v);
			virologistOrder.add(v);
		}

		ArrayList<Integer>[] al = new ArrayList[50];

		for (int i = 0; i < 50; i++) {
			al[i] = new ArrayList<Integer>();
		}

		/** Szomszédságok kialakítása */
		al[0].addAll(Arrays.asList(1, 17));
		al[1].addAll(Arrays.asList(0, 2, 15, 16, 17));
		al[2].addAll(Arrays.asList(1, 3, 15));
		al[3].addAll(Arrays.asList(2, 4, 14, 15));
		al[4].addAll(Arrays.asList(3, 5, 14));
		al[5].addAll(Arrays.asList(4, 6, 13, 14));
		al[6].addAll(Arrays.asList(5, 7, 12, 13));
		al[7].addAll(Arrays.asList(6, 8, 10, 11, 12));
		al[8].addAll(Arrays.asList(7, 9, 10));
		al[9].addAll(Arrays.asList(8, 10, 28));
		al[10].addAll(Arrays.asList(7, 8, 9, 11, 28));
		al[11].addAll(Arrays.asList(7, 8, 10, 12, 25, 26, 27));
		al[12].addAll(Arrays.asList(6, 7, 11, 13, 25, 26));
		al[13].addAll(Arrays.asList(5, 6, 12, 14, 24, 25));
		al[14].addAll(Arrays.asList(3, 4, 5, 13, 15, 21, 22, 23, 24));
		al[15].addAll(Arrays.asList(1, 2, 3, 14, 16, 21));
		al[16].addAll(Arrays.asList(1, 15, 17, 20, 21));
		al[17].addAll(Arrays.asList(0, 1, 16, 18));
		al[18].addAll(Arrays.asList(17, 19, 38, 39));
		al[19].addAll(Arrays.asList(18, 20, 38));
		al[20].addAll(Arrays.asList(16, 19, 21, 36, 37, 38));
		al[21].addAll(Arrays.asList(14, 15, 16, 20, 22, 23, 36));
		al[22].addAll(Arrays.asList(14, 21, 23, 35, 36));
		al[23].addAll(Arrays.asList(14, 22, 24, 35, 34));
		al[24].addAll(Arrays.asList(13, 14, 23, 25, 33, 34));
		al[25].addAll(Arrays.asList(13, 12, 24, 26, 33));
		al[26].addAll(Arrays.asList(11, 25, 27, 32, 33));
		al[27].addAll(Arrays.asList(11, 26, 28, 29, 31, 32));
		al[28].addAll(Arrays.asList(9, 10, 27, 29));
		al[29].addAll(Arrays.asList(27, 28, 30, 31));
		al[30].addAll(Arrays.asList(29, 31, 49));
		al[31].addAll(Arrays.asList(27, 29, 30, 32, 47, 48, 49));
		al[32].addAll(Arrays.asList(26, 27, 31, 33, 34, 46));
		al[33].addAll(Arrays.asList(24, 25, 26, 32, 34));
		al[34].addAll(Arrays.asList(23, 24, 33, 35, 44, 46));
		al[35].addAll(Arrays.asList(22, 23, 34, 36, 44));
		al[36].addAll(Arrays.asList(20, 21, 22, 35, 37, 43, 44));
		al[37].addAll(Arrays.asList(20, 36, 38, 41, 42, 43));
		al[38].addAll(Arrays.asList(18, 19, 20, 37, 39, 40, 41));
		al[39].addAll(Arrays.asList(18, 38, 40));
		al[40].addAll(Arrays.asList(38, 39, 41));
		al[41].addAll(Arrays.asList(37, 38, 40, 42));
		al[42].addAll(Arrays.asList(37, 41, 43));
		al[43].addAll(Arrays.asList(36, 37, 42, 44, 45));
		al[44].addAll(Arrays.asList(34, 35, 36, 43, 45, 46));
		al[45].addAll(Arrays.asList(43, 44, 46, 47));
		al[46].addAll(Arrays.asList(32, 34, 44, 45, 47));
		al[47].addAll(Arrays.asList(31, 46, 48));
		al[48].addAll(Arrays.asList(31, 47, 49));
		al[49].addAll(Arrays.asList(30, 31, 48));

		for(int i = 0; i < 50; i++){
			for (int j = 0; j < al[i].size(); j++) {
				fields2.get(i).addNeighbourField(fields2.get(al[i].get(j)));
			}
		}
	}

	/**
	 * Következő kör
	 * */
	public void doRound() {
		if(checkWinCondition()) {
			Game.getInstance().endGame();
			return;
		}
		if (virologistOrder != null && virologistOrder.size() > 0) {
			for (State s : virologistOrder.getFirst().getStates()) {
				if (!s.Do()) {
					virologistOrder.getFirst().removeState(s);
					removeState(s);
				}
			}
			virologistOrder.add(virologistOrder.removeFirst());
		}
		round++;
	}

	/**
	 * Nyertes vizsgálata
	 * */
	public boolean checkWinCondition() {
		if (getCurrentVirologist() != null && getCurrentVirologist().getCodes().size() == codes.size()) //todo - ebbe így lehet bele fog zavarni a bearvirus
			return true;
		else
			return false;
	}

	/**
	 * Állapot törlése
	 * */
	public void removeState(State s) {
		playerStates.remove(s);
	}

	/**
	 * Virológus törlése
	 * */
	public void removeVirologist(Virologist v) {
		v.getField().remove(v);
		virologists.remove(SearchKeyWithValue(virologists,v));
		virologistOrder.remove(v);
	}

	public static Round_Manager getInstance(int numberOfPlayers){
		if (roundManagerSingleton != null)
			return roundManagerSingleton;
		else
			roundManagerSingleton = new Round_Manager(numberOfPlayers);
		return roundManagerSingleton;
	}

	public static Round_Manager getInstance(){
		if (roundManagerSingleton != null)
			return roundManagerSingleton;
		else
			roundManagerSingleton = new Round_Manager(2);
		return roundManagerSingleton;
	}

	public static void setInstance(Round_Manager rm){
		if (rm != null)
			roundManagerSingleton = rm;
		else
			roundManagerSingleton = new Round_Manager(2);
	}

	private static <T> String SearchKeyWithValue(HashMap<String,T> dic,T searchItem) {
		for (Map.Entry<String, T> entry : dic.entrySet()) {
			if (entry.getValue() == searchItem)
				return entry.getKey();
		}
		return null;
	}

    public Virologist getCurrentVirologist() {
		if (virologistOrder != null && virologistOrder.size() > 0)
			return virologistOrder.getFirst();
		else
			return null;
    }

	public int getRound() {
		return round;
	}

	public HashSet<Code> getCodes() {
		return codes;
	}
}