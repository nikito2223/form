package form;

// Arc Package
import arc.*;
import arc.math.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.util.*;
// Mindustry Package

import mindustry.content.SectorPresets;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.ui.Styles;
import mindustry.ui.fragments.MenuFragment;
import mindustry.ui.dialogs.*;
// Vanilla Upgraded Package
import form.content.*;
//static
import static arc.Core.*;
import static mindustry.Vars.*;
import static mindustry.game.EventType.*;
// End

public class FormMod extends Mod{

    public FormMod(){
    	Log.info("Start.");

        
    }
     @Override
    public void loadContent(){
        FormAttributes.load();
        FormWeathers.load();
        FormItems.load();
        FormLiquid.load();
        new FormSchematics().load();
        new FormUnits().load();
        FormBlocks.load();
        FormPlanets.load();
        FormSectors.load();

        //TechTree
        SerpuloTechTree.load();
        MathurakTechTree.load();
    }
}
