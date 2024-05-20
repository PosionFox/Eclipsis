package eclipsis.content.blocks;

import arc.graphics.*;
import arc.math.*;
import arc.struct.*;
import mindustry.*;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.DrawPart.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.unit.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.legacy.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.*;

public class EBlocks {
    public static Block
        //turrets
        regression, fulmination;

    public static void load(){
        regression = new ItemTurret("regression"){{
            requirements(Category.turret, with(Items.copper, 25));
            ammo(
                Items.copper, new BasicBulletType(2.5f, 12){{
                    width = 1f;
                    height = 1f;
                    lifetime = 10f;
                    ammoMultiplier = 5;
                }}
            );

            recoil = 0.5f;
            shootY = 1f;
            reload = 100f;
            range = 50;
            shootCone = 16f;
            ammoUseEffect = Fx.casing1;
            health = 100;
            inaccuracy = 2f;
            rotateSpeed = 16f;

            limitRange();
        }};
    }
}
