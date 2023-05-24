import hu.bme.iet_hf_group.wizard.earlyacces_source.Material;
import hu.bme.iet_hf_group.wizard.earlyacces_source.Virologist;

import hu.bme.iet_hf_group.wizard.earlyacces_source.code.*;
import hu.bme.iet_hf_group.wizard.earlyacces_source.field.*;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore.Game;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gameCore.Round_Manager;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Axe;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Bag;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Cape;
import hu.bme.iet_hf_group.wizard.earlyacces_source.gear.Glove;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Bear;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Dancing;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Immune;
import hu.bme.iet_hf_group.wizard.earlyacces_source.state.Paralysed;
import hu.bme.iet_hf_group.wizard.earlyacces_source.visitors.deleteCollectibleVisitor;
import hu.bme.iet_hf_group.wizard.graphics.MenuFrame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestMain {
    public static void main(String[] args) {

        MenuFrame menu = new MenuFrame();

        String line;
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        Round_Manager.getInstance();

        boolean EXIT = false;
        while (!EXIT) {
            System.out.println(
                    "\n\n0. Exit\n" +
                            "1. create\n" +
                            "2. set\n" +
                            "3. virologist\n" +
                            "4. add\n" +
                            "5. save\n" +
                            "6. load\n" +
                            "7. code\n" +
                            "8. print\n" +
                            "");

            line = scanner.nextLine();
            if(line.length() > 0) {
                String[] commands = line.split(" ");
                if (commands != null && commands.length == 1 && commands[0].equals("0")) {
                    EXIT = true;
                    continue;
                }
                Input(commands);
            }
        }
        System.out.println("exit");
    }

    public static void Input(String[] commands) {
        TrimArray(commands);
        if (commands != null) {
            switch (commands[0]) {
                case "create": {
                    Create(commands);
                    break;
                }
                case "set": {
                    Set(commands);
                    break;
                }
                case "virologist": {
                    VirologistCommand(commands);
                    break;
                }
                case "add": {
                    Add(commands);
                    break;
                }
                case "save": {
                    Save(commands);
                    break;
                }
                case "load": {
                    Load(commands);
                    break;
                }
                case "code": {
                    Code(commands);
                    break;
                }
                case "print": {
                    Print(commands);
                    break;
                }

                default: {
                    System.out.println("Syntax error");
                    break;
                }
            }
        }
        else
            System.out.println("Syntax error");
    }

    private static void Create(String[] commands) {
        if (commands.length >= 3) {
            switch (commands[1]) {
                case "virologist": {
                    Round_Manager.getInstance().addVirologists(commands[2], new Virologist());
                    break;
                }
                case "freefield": {
                    Round_Manager.getInstance().addField(commands[2], new FreeField());
                    break;
                }
                case "infectiouslab": {
                    Paralysing p = new Paralysing();
                    Round_Manager.getInstance().addField(commands[2], new InfectiousLaboratory(p));
                    Round_Manager.getInstance().addCode(p);
                    break;
                }
                case "lab": {
                    Paralysing p = new Paralysing();
                    Round_Manager.getInstance().addField(commands[2], new Laboratory(p));
                    Round_Manager.getInstance().addCode(p);
                    break;
                }
                case "shelter": {
                    Round_Manager.getInstance().addField(commands[2], new Shelter());
                    break;
                }
                case "storage": {
                    Round_Manager.getInstance().addField(commands[2], new Storage());
                    break;
                }
                default:
                    System.out.println("Syntax error");
                    break;
            }
        }
        else
            System.out.println("Syntax error");
    }

    private static void Set(String[]commands) {
        if (commands.length >= 5) {
            switch (commands[1]) {
                case "virologist": {
                    Field f = Round_Manager.getInstance().getField(commands[4]);
                    if(f != null) {
                        Virologist v = Round_Manager.getInstance().getVirologist(commands[2]);
                        if (v != null) v.setField(f);
                    }
                    break;
                }
                case "field": {
                    Field f = Round_Manager.getInstance().getField(commands[2]);
                    if (f != null) {
                        switch (commands[3]) {
                            case "virologist": {
                                Virologist v = Round_Manager.getInstance().getVirologist(commands[4]);
                                if (v != null) f.accept(v);
                                break;
                            }
                            case "field": {
                                Field f2 = Round_Manager.getInstance().getField(commands[4]);
                                if (f2 != null) f.addNeighbourField(f2);
                                break;
                            }
                            default:
                                System.out.println("Syntax error");
                                break;
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Syntax error");
                    break;
            }
        }
    }

    private static void VirologistCommand(String[] commands) {
        Virologist v = Round_Manager.getInstance().getVirologist(commands[1]);
        if (v != null) {
            if (commands[2].equals("collect")) {
                v.searchField();
            }
            else if (commands.length == 4) {
                switch (commands[2]) {
                    case "move": {
                        Field f = Round_Manager.getInstance().getField(commands[3]);
                        if (f != null) v.move(f);
                        break;
                    }
                    case "rob": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if (v2 != null)
                            v.rob(v2);
                        break;
                    }
                    case "remove": {
                        if (commands[3].equals("material"))
                            v.getMaterial().acceptVisitor(new deleteCollectibleVisitor(), v);
                        break;
                    }
                    case "axe": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if(v2 != null)
                            v.useGear(v2);
                        break;
                    }
                    case "bearvirus": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if (v2 != null)
                            v.useCode(new BearVirus(), v2);
                        break;
                    }
                    case "chorea": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if (v2 != null)
                            v.useCode(new Chorea(), v2);
                        break;
                    }
                    case "oblivion": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if (v2 != null)
                            v.useCode(new Oblivion(), v2);
                        break;
                    }
                    case "paralysing": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if (v2 != null)
                            v.useCode(new Paralysing(), v2);
                        break;
                    }
                    case "protection": {
                        Virologist v2 = Round_Manager.getInstance().getVirologist(commands[3]);
                        if (v2 != null)
                            v.useCode(new Protection(), v2);
                        break;
                    }
                    default:
                        System.out.println("Syntax error");
                        break;
                }
            }
            else if (commands.length == 5) {
                if (commands[2].equals("remove") && commands[3].equals("gear"))
                    /** indexszel removeolunk */
                    v.getGears().get(Integer.parseInt(commands[4])).acceptVisitor(new deleteCollectibleVisitor(), v);
                    else
                        System.out.println("Syntax error");
            }
            else
                System.out.println("Syntax error");

        }
    }

    private static void Add(String[] commands) {
        if (commands.length >= 3) {
            switch (commands[1]) {
                case "virologist": {
                    Virologist v = Round_Manager.getInstance().getVirologist(commands[2]);
                    if (v != null) {
                        switch (commands[3]) {
                            case "material": {
                                Material m = new Material();
                                m.setBaseField(new Storage());
                                v.add(m);
                                break;
                            }
                            case "axe": {
                                Axe a = new Axe();
                                a.setBaseField(new Shelter());
                                v.add(a);
                                break;
                            }
                            case "bag": {
                                Bag b = new Bag();
                                b.setBaseField(new Shelter());
                                v.add(b);
                                break;
                            }
                            case "cape": {
                                Cape c = new Cape();
                                c.setBaseField(new Shelter());
                                v.add(c);
                                break;
                            }
                            case "glove": {
                                Glove g = new Glove();
                                g.setBaseField(new Shelter());
                                v.add(g);
                                break;
                            }
                            case "protection": {
                                Protection p = new Protection();
                                p.setBaseField(new Laboratory(p));
                                Round_Manager.getInstance().addCode(p);
                                v.add(p);
                            }
                            case "bearvirus": {
                                BearVirus b = new BearVirus();
                                b.setBaseField(new Laboratory(b));
                                v.add(b);
                            }
                            case "chorea": {
                                Chorea c = new Chorea();
                                c.setBaseField(new Laboratory(c));
                                Round_Manager.getInstance().addCode(c);
                                v.add(c);
                                break;
                            }
                            case "oblivion": {
                                Oblivion o = new Oblivion();
                                o.setBaseField(new Laboratory(o));
                                Round_Manager.getInstance().addCode(o);
                                v.add(o);
                                break;
                            }
                            case "paralysing": {
                                Paralysing p = new Paralysing();
                                p.setBaseField(new Laboratory(p));
                                Round_Manager.getInstance().addCode(p);
                                v.add(p);
                                break;
                            }
                            case "dancing": {
                                v.addState(new Dancing());
                                break;
                            }
                            case "immune": {
                                v.addState(new Immune());
                                break;
                            }
                            case "para": {
                                v.addState(new Paralysed());
                                break;
                            }
                            case "bear": {
                                v.addState(new Bear());
                                break;
                            }
                            default:
                                System.out.println("Syntax error");
                                break;
                        }
                    }
                    break;
                }
                case "shelter": {
                    Shelter s = (Shelter) Round_Manager.getInstance().getField(commands[2]);
                    if (s != null) {
                        switch (commands[3]) {
                            case "axe": {
                                Axe a = new Axe();
                                a.setBaseField(s);
                                s.addGear(a);
                                break;
                            }
                            case "bag": {
                                Bag b = new Bag();
                                b.setBaseField(s);
                                s.addGear(b);
                                break;
                            }
                            case "cape": {
                                Cape c = new Cape();
                                c.setBaseField(s);
                                s.addGear(c);
                                break;
                            }
                            case "glove": {
                                Glove g = new Glove();
                                g.setBaseField(s);
                                s.addGear(g);
                                break;
                            }
                            default:
                                System.out.println("Syntax error");
                                break;
                        }
                    }
                    break;
                }
                default:
                    System.out.println("Syntax error");
                    break;
            }
        }
    }

    private static void Save(String[] commands) {
        try {
            Game.getInstance().saveGame();
        }
        catch (Exception e){
            System.out.println("Hiba a mentés során");
        }
    }

    private static void Load(String[] commands) {
        try {
            Game.getInstance().loadGame();
        }
        catch (Exception e){
            System.out.println("Hiba a betöltés során");
        }
    }

    private static  void TrimArray(String[] array) {
        for(int i=0;i<array.length;i++) {
            array[i]=array[i].trim();
        }
    }

    private static void Code(String[] commands) {
        try {
            String localDir= System.getProperty("user.dir");
            Scanner scanner = new Scanner(new FileInputStream(localDir+"\\tests\\InputFiles\\test_"+commands[1]+".txt"));
            String input="";
            while (scanner.hasNext()) {
                input = scanner.nextLine();
                Input(input.split(" "));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File read problem");
        }
    }

    private static void Print(String[] commands) {
        System.out.println();
        if (commands.length >= 3) {
            switch (commands[1]) {
                case "virologist": {
                    Virologist v = Round_Manager.getInstance().getVirologist(commands[2]);
                    if (v != null) v.Print();
                    break;
                }
                case "field": {
                    Field f = Round_Manager.getInstance().getField(commands[2]);
                    if (f != null) f.Print();
                    break;
                }
                default:
                    System.out.println("Syntax error");
                    break;
            }
        }
        else
            System.out.println("Syntax error");

    }


}
