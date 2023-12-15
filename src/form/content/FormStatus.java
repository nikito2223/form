package form.content;

import form.graphics.FormPal;
import mindustry.type.*;
import mindustry.content.*;
import arc.graphics.*;

public class FormStatus {

	public static StatusEffect
            hacker, coldrains, platinum, rhodium;

	public static void load(){
        hacker = new StatusEffect("hacker") {{
			color = Color.valueOf("#ffc455");
            damage = 0.167f;
            speedMultiplier = 0.7f; 
            healthMultiplier = 0.8f;
            effect = FormFx.hacker;
            effectChance = 0.1f;
        }}; 
        coldrains = new StatusEffect("coldrains") {{
            color = FormPal.hacked;
            speedMultiplier = 0.6f;
            effect = Fx.blastExplosion;
        }};
        platinum = new StatusEffect("platinum") {{
            color = FormPal.platinumBack;
            speedMultiplier = 0.6f;
            effect = FormFx.platinum;
        }};
        rhodium = new StatusEffect("rhodium") {{
            color = FormPal.rhodium;
            speedMultiplier = 0.8f;
            damage = 0.167f;
            effectChance = 0.3f;
            effect = FormFx.rhodium;
        }};
    }
}