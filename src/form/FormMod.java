package form;

// Arc Package
import arc.*;
import arc.util.*;
// Mindustry Package
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mods.*;
import mindustry.ui.Styles;
import mindustry.ui.dialogs.*;
// Form Upgraded Package
import form.content.*;
//static
import static arc.Core.*;
import static mindustry.Vars.*;
import static mindustry.game.EventType.*;
// End

public class FormMod extends Mod{

    private static String Logs = "LogTexr";

    public FormMod(){
    	Log.info(Logs);
        Events.on(ClientLoadEvent.class, e -> {
         Time.runTask(10f, () -> {
            BaseDialog dialog = new BaseDialog("MainMenu-help");
            dialog.cont.add(Logs).row();
            dialog.cont.button("Okey", dialog::hide).size(100f, 50f);
            dialog.show();
            });   
        });
    }
     @Override
    public void loadContent(){
        FormAttributes.load();
        FormWeathers.load();
        FormTeam.load();
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
