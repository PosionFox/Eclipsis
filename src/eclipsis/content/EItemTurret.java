package eclipsis.content;

import arc.util.Time;
import mindustry.entities.Effect;
import mindustry.entities.bullet.BulletType;
import mindustry.world.blocks.defense.turrets.ItemTurret;

public class EItemTurret extends ItemTurret {

    public EItemTurret(String name) {
        super(name);
    }

    public class EItemTurretBuild extends ItemTurretBuild {

        public Effect afterShootEffect = EFx.steamStream;

        @Override
        protected void shoot(BulletType type) {
            super.shoot(type);

            Time.runTask(30f, () -> {
                afterShootEffect.at(
                    x,
                    y,
                    rotation
                );
            });
        }
    }
}
