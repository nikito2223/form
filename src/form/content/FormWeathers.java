package form.content;

import arc.graphics.Color;
import arc.util.*;
import mindustry.content.Weathers;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.type.weather.*;
import mindustry.content.*;
import mindustry.world.meta.*;
import form.content.*;
import form.content.FormBlocks.*;

public class FormWeathers {
    public static Weather 
	wind,
	likuerain;

    public static void load() {

        wind = new RainWeather("wind"){{
            attrs.set(Attribute.light, -0.2f);
            attrs.set(Attribute.water, 0.2f);
            status = StatusEffects.wet;
            sound = Sounds.rain;
            soundVol = 0.25f;
        }};
		likuerain = new RainWeather("likuerain"){{
            attrs.set(Attribute.light, -0.2f);
            attrs.set(Attribute.water, 0.2f);
            status = StatusEffects.wet;
            sound = Sounds.rain;
            soundVol = 0.25f;
        }};
    }
}
