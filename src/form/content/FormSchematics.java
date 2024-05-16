package form.content;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

public class FormSchematics {
    public static Schematic coreDawn;

    public void load() {
        coreDawn = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZZDJKCkpKLbS16/MLy0p1UtK1XcNi/Q3cKwwyqkyYOBOSS1OLsosKMnMz2NgYGDLSUxKzSlmYIqOZWTgSs4vStUtzkgsSgFKMYIQkAAAhSEXTA==");
    }
}
