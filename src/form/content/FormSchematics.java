package form.content;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

public class FormSchematics {
    public static Schematic coreDawn;

    public void load() {
        coreDawn = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZeAty8zJSUxP9UkszUvOYOBOSS1OLsosKMnMz2NgYGDLSUxKzSlmYIqOZWQQzU/KySwDSugm5xel6kI1AlUxghCQAAAzvhc/");
    }
}
