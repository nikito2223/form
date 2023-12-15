package form.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class FormItems {
    public static Item lithium, platinum, vanadium, rhodium;

    public static final Seq<Item> mathurakItems = new Seq<>(), mathurakOnlyItems = new Seq<>();

    public static void load(){
        lithium = new Item("lithium", Color.valueOf("4d59a1")){{
            hardness = 1;
            explosiveness = 0.4f;
            cost = 1f;
        }};
        platinum = new Item("platinum", Color.valueOf("d76dd1")){{
            cost = 1.9f;
            hardness = 2;
        }};
		rhodium = new Item("rhodium", Color.valueOf("a0ecbd")){{
            cost = 1.9f;
            hardness = 2;
        }};
        vanadium = new Item("vanadium", Color.valueOf("4b4b4b")){{
            cost = 1.9f;
            hardness = 2;
        }};

        mathurakItems.addAll(lithium, platinum, rhodium, vanadium, graphite, silicon);

        mathurakOnlyItems.addAll(erekirItems).removeAll(serpuloItems);
    }
}
