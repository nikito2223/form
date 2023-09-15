package form.content;

import mindustry.world.meta.Attribute;
import form.content.*;

public class FormAttributes {
    public static Attribute windPower;

    public static void load() {
        windPower = Attribute.add("windPower");
    }
}
