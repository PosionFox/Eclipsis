package eclipsis.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Lines;
import arc.math.Interp;
import arc.math.Mathf;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.StatusEffects;
import mindustry.entities.Effect;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.StatusEffect;

public class EStatusEffects {
    public static StatusEffect
        corrosion;

    public static void load(){
        corrosion = new StatusEffect("corrosion"){{
            localizedName = "Corrosion";
            description = "Corrodes the afflicted, dealing damage to them over time.";
            speedMultiplier = 0.9f;
            damage = 0.5f;
            damageMultiplier = 0.5f;
        }};
    }
}
