package eclipsis.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.draw.DrawLiquidTile;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static eclipsis.content.ESounds.regressionShoot;
import static mindustry.Vars.*;

public class EUnitTypes {
    public static UnitType
        delta, scimitar;

    public static void load(){
        //region core
        delta = new UnitType("delta"){{
            localizedName = "Delta";
            aiController = BuilderAI::new;
            isEnemy = false;
            constructor = UnitEntity::create;

            lowAltitude = true;
            flying = true;
            mineSpeed = 5f;
            mineTier = 1;
            buildSpeed = 0.5f;
            drag = 0.1f;
            speed = 5f;
            rotateSpeed = 30f;
            accel = 0.2f;
            fogRadius = 0f;
            itemCapacity = 45;
            health = 200f;
            engineOffset = 4f;
            hitSize = 8f;
            alwaysUnlocked = true;

            weapons.add(new Weapon("small-basic-weapon"){{
                reload = 12f;
                top = false;
                ejectEffect = Fx.casing1;
                shootSound = regressionShoot;

                bullet = new BasicBulletType(3f, 10){{
                    width = 4f;
                    height = 8f;
                    lifetime = 60f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                }};
            }});
        }};

        scimitar = new UnitType("scimitar") {{
            localizedName = "Scimitar";
            aiController = GroundAI::new;
            isEnemy = false;
            constructor = UnitEntity::create;

            lowAltitude = true;
            drag = 0.1f;
            speed = 2f;
            accel = 0.1f;
            rotateSpeed = 16f;
            fogRadius = -1f;
            itemCapacity = 32;
            health = 300f;
            hitSize = 8f;
            alwaysUnlocked = true;

            weapons.add(new Weapon("small-basic-weapon"){{
                reload = 16f;
                top = false;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(3f, 10){{
                    width = 4f;
                    height = 8f;
                    lifetime = 60f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.01f;
                }};
            }});
        }};
        //endregion
    }
}
