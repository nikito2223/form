package form.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class FormLiquid {
    public static Liquid distilledwater, fueloli, air, carbondioxide, lava, acid;

    public static void load() {
        //liquid
        distilledwater = new Liquid("distilledwater", Color.valueOf("20B2AA")){{
            heatCapacity = 0.4f;
            effect = StatusEffects.wet;
            boilPoint = 0.7f;
            gasColor = Color.grays(0.9f);
            alwaysUnlocked = true;
        }};
        fueloli = new Liquid("fueloli", Color.valueOf("121212")){{
            viscosity = 0.2f;
            flammability = 2.2f;
            explosiveness = 3.2f;
            heatCapacity = 1.7f;
            barColor = Color.valueOf("121212");
            effect = StatusEffects.tarred;
            boilPoint = 0.65f;
        }};
        lava = new Liquid("lava", Color.valueOf("ff7806")){{
            temperature = 100f;
            viscosity = 0.9f;
            effect = StatusEffects.melting;
            lightColor = Color.valueOf("bf5c07").a(0.4f);
        }};
        acid = new Liquid("acid", Color.valueOf("30801a")){{
            temperature = 10.38f;
            viscosity = 0.10f;
            lightColor = Color.valueOf("30801a").a(0.4f);
        }};
        //gases
		air = new Liquid("air", Color.valueOf("a0a0a0")){{
            gas = true;
            flammability = 0.01f;
        }};
		carbondioxide = new Liquid("carbondioxide", Color.valueOf("a0a1a0a")){{
            gas = true;
            flammability = 0.1f;
			temperature = 0.01f;
        }};
    }
}
