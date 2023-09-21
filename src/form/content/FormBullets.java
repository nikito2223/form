package form.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;

public class FormBullets {
    public static BulletType meteorSpark;

    public static void load() {
        meteorSpark = new BasicBulletType(4f, 40f){{
            lifetime = 20;
            width = 6; height = 6;
            incendAmount = 1;
            backColor = Color.valueOf("ad6b00");
            frontColor = Color.valueOf("ff9d00");
        }};
    }
}
