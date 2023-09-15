package form.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class FormLiquid {
    public static Liquid distilledwater, fueloli, air, carbondioxide;

    public static void load() {
        distilledwater = new Liquid("distilledwater", Color.valueOf("20B2AA")){{
            viscosity = 0.2f;
            effect = StatusEffects.freezing;
            temperature = 0.14f;
            capPuddles = false;
            heatCapacity = 0.9f;
            boilPoint = 1.50f;

        }};
        fueloli = new Liquid("fueloli", Color.valueOf("121212")){{
            viscosity = 0.2f;
            flammability = 2.2f;
            explosiveness = 3.2f;
            heatCapacity = 1.7f;
            barColor = Color.valueOf("121212");
            effect = StatusEffects.tarred;
            boilPoint = 0.65f;
            gasColor = Color.grays(0.4f);
        }};
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
