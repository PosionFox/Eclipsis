package eclipsis;

import arc.*;
import arc.util.*;
import eclipsis.content.*;
import mindustry.Vars;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class Eclipsis extends Mod{

    public Eclipsis(){
        Log.info("Loaded Main Eclipsis constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Eclipsis");
                dialog.cont.add("Thanks for playing Eclipsis!").row();
                dialog.cont.add("This mod is still in heavy development.").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.button("Ok", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        Log.info("Loading Eclipsis content...");
        ESounds.load();
        EStatusEffects.load();
        EItems.load();
        ELiquids.load();
        EBullets.load();
        EUnitTypes.load();
        EBlocks.load();
        EPlanets.load();
        ESectorPresets.load();
        ETechTree.load();
        Log.info("Eclipsis content loaded!");
    }

}
