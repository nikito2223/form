package form;

// Arc Package
import arc.*;
import arc.util.*;
// Mindustry Package
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
// Form Upgraded Package
import form.content.*;
//static
import static mindustry.game.EventType.*;
// End

public class FormMod extends Mod{
 

    public FormMod(){
        Events.on(ClientLoadEvent.class, e -> {
         Time.runTask(10f, () -> {
            BaseDialog dialog = new BaseDialog("Readme");
            dialog.cont.add("@dialog.form-readme.name").row();
            dialog.cont.button("@dialog.form-okey.name", dialog::hide).size(100f, 50f);
            dialog.show();
            });   
        });

    }
    @Override
    public void loadContent(){
        FormStatus.load();
        FormAttributes.load();
        FormWeathers.load();
        FormTeam.load();
        FormItems.load();
        FormLiquid.load();
        new FormSchematics().load();
        FormUnits.load();
        FormBlocks.load();
        FormPlanets.load();
        FormSectors.load();

        //TechTree
        SerpuloTechTree.load();
        MathurakTechTree.load();
    }
}
