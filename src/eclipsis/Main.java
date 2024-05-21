package eclipsis;

import arc.*;
import arc.graphics.Color;
import arc.util.*;
import eclipsis.content.EBullets;
import eclipsis.content.EItems;
import eclipsis.content.EBlocks;
import eclipsis.content.planets.ChrysidirosPlanetGenerator;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.mod.*;
import mindustry.type.*;
import mindustry.ui.dialogs.*;

import static mindustry.content.Planets.sun;

public class Main extends Mod{

    public Main(){
        Log.info("Loaded Main Eclipsis constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Eclipsis");
                dialog.cont.add("Thanks for playing Eclipsis!").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.button("Ok", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        Log.info("Loading Eclipsis content.");
        EItems.load();
        EBullets.load();
        EBlocks.load();

        Planet chrysidiros = new Planet("Chrysidiros", sun, 1f, 2){{
            generator = new ChrysidirosPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 4);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 4, 0.8f, 0.64f, 8, new Color().set(Pal.spore).mul(0.9f).a(0.75f), 2, 0.45f, 1f, 0.128f),
                    new HexSkyMesh(this, 2, 0.4f, 0.32f, 4, Color.acid.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.64f),
                    new HexSkyMesh(this, 1, 0.2f, 0.16f, 2, Color.acid.cpy().lerp(Pal.spore, 0.55f).a(0.75f), 2, 0.45f, 1f, 0.32f)
            );

            launchCapacityMultiplier = 0.5f;
            sectorSeed = 1337;
            allowWaves = true;
            allowWaveSimulation = true;
            allowSectorInvasion = true;
            allowLaunchSchematics = true;
            enemyCoreSpawnReplace = true;
            allowLaunchLoadout = true;
            //doesn't play well with configs
            prebuildBase = false;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.showSpawns = false;
            };
            iconColor = Color.acid;
            atmosphereColor = Color.acid;
            atmosphereRadIn = 0.2f;
            atmosphereRadOut = 0.4f;
            startSector = 1;
            alwaysUnlocked = false;
            landCloudColor = Color.acid;
            hiddenItems.addAll(Items.erekirItems).removeAll(Items.serpuloItems);
        }};
    }

}
