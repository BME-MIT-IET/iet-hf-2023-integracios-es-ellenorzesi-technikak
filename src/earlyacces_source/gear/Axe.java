package earlyacces_source.gear;

import earlyacces_source.Virologist;
import earlyacces_source.code.Code;
import earlyacces_source.gameCore.Round_Manager;

/**
 * A virológus által felvehető balta osztálya
 */
public class Axe extends Gear {
    /***
     * KOnstruktor
     */
    public Axe() {
        counter = 1;
    }

    /***
     *
     * @param def A védekező virológus
     * @param atk A kezdeményező virológus
     * @param c A támadáshoz használt kód
     * @return A művelet sikeressége
     */
    @Override
    public boolean use(Virologist def, Virologist atk, Code c) {
        if (c == null) {
            Round_Manager.getInstance().removeVirologist(def);
            if (--counter <= 0) atk.delete(this);
            return true;
        }
        else {
            return false;
        }
    }
}
