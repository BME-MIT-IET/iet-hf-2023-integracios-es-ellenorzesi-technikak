package hu.bme.iet_hf_group.wizard.graphics;

import hu.bme.iet_hf_group.wizard.earlyacces_source.field.*;

import java.awt.*;

/**
 * A mezők színét meghatározó visitor
 */
public class FieldColourVisitor {
    public Color visit(Field field)            { return Color.GREEN; }
    public Color visit(Shelter shelter)        { return Color.BLACK; }
    public Color visit(Laboratory laboratory)  { return Color.MAGENTA; }
    public Color visit(Storage storage)        { return new Color(180,120,90); }
    public Color visit(FreeField freeField)    { return new Color(0, 120, 0); }
}
