package form.content;

import arc.graphics.g2d.*;
import mindustry.entities.Effect;
import form.graphics.FormPal;
import mindustry.graphics.Drawf;
import arc.graphics.g2d.Lines;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.randLenVectors;
import arc.math.*;


public class FormFx {
	

	public static Effect 
	hacker = new Effect(40f, e -> {
        color(FormPal.hacked);
 
        randLenVectors(e.id, 2, 1f + e.fin() * 2f, (x, y) -> {
            Fill.square(e.x + x, e.y + y, e.fslope() * 1.3f, 45f);
        });
    }),

    platinum = new Effect(30f, e -> {
        color(FormPal.platinumFront);
         e.scaled(8, i -> {
            stroke(5f * i.fout());
            Lines.circle(e.x, e.y, 8f + i.fin() * 26f);
        });
        color(FormPal.platinumBack);
        stroke(e.fout());

        randLenVectors(e.id + 1, 8, 1f + 25f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
        });

        Drawf.light(e.x, e.y, 50f, FormPal.platinumBack, 0.8f * e.fout());
    }),
    rhodium = new Effect(30f, e -> {
        color(FormPal.rhodiumFront);
         e.scaled(9, i -> {
            stroke(8f * i.fout());
            Lines.circle(e.x, e.y, 9f + i.fin() * 28f);
        });
        color(FormPal.rhodium);
        stroke(e.fout());

        randLenVectors(e.id + 1, 7, 1f + 35f * e.finpow(), (x, y) -> {
            lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 2f + e.fout() * 3f);
        });

        Drawf.light(e.x, e.y, 50f, FormPal.rhodium, 0.9f * e.fout());
    });
}