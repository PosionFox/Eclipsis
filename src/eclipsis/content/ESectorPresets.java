package eclipsis.content;

import arc.util.Log;
import mindustry.type.*;

import static eclipsis.content.EPlanets.*;

public class ESectorPresets {
    public static SectorPreset
        improbableOutset;

    public static void load(){
        improbableOutset = new SectorPreset("improbableOutset", chrysidiros, 1){{
            localizedName = "Improbable Outset";
            alwaysUnlocked = true;
            addStartingItems = true;
            captureWave = 5;
            difficulty = 0;
            overrideLaunchDefaults = true;
            noLighting = true;
            startWaveTimeMultiplier = 3f;
        }};
    }
}
