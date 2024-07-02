package eclipsis.content;

import arc.graphics.Blending;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.struct.Seq;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.StatusEffects;
import mindustry.entities.*;
import mindustry.entities.abilities.MoveEffectAbility;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.game.Team;
import mindustry.gen.*;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

import static arc.graphics.g2d.Draw.color;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.randLenVectors;
import static rhino.TopLevel.Builtins.Array;

public class EBullets {
    public static BulletType
        regressionBullet, dissensionBullet, regressionDiamondBullet, fulminationBullet;

    public static void load(){
        regressionBullet = new BasicBulletType(10f, 5f){{
            lifetime = 60f;
            width = 2f;
            height = 10f;
        }};

        regressionDiamondBullet = new BasicBulletType(16f, 32f){{
            lifetime = 120f;
            width = 4f;
            height = 8f;
            reloadMultiplier = 0.25f;
            pierce = true;
        }};

        fulminationBullet = new ContinuousLaserBulletType(2f){{
            lifetime = 120f;
            length = 100f;
            width = 2f;
            colors = new Color[]{Color.white, Color.purple, Color.red, Color.yellow};
            hitEffect = Fx.hitMeltdown;
            hitColor = Color.purple;
            drawSize = 200f;
            chargeEffect = new MultiEffect(EFx.fulminationCharge);
        }};

        dissensionBullet = new BasicBulletType(32f, 32f) {{
            width = 2;
            height = 16f;
            trailEffect = Fx.smoke;
        }};
    }
}
