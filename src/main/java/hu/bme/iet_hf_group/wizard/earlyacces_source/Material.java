package earlyacces_source;

import earlyacces_source.visitors.CollectibleVisitor;
import earlyacces_source.visitors.addCollectibleVisitor;

/**
 * A virológusok által gyűjthető anyagok osztálya
 */
public class Material extends Collectible {
    /**
     * Konstruktor
     * */
    public Material() { }

    /**
     * Az anyagot odaadja a virológusnak
     * @param v Az a virológus, akihez kerül az anyag
     * */
    @Override
    public boolean collect(Virologist v) {
        if (acceptVisitor(new addCollectibleVisitor(), v)) {
            baseField.removeItem(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean acceptVisitor(CollectibleVisitor visitor, Virologist v) {
        return visitor.visit(this, v);
    }
}
