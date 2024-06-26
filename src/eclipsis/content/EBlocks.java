package eclipsis.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.part.RegionPart;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.DrawTurret;
import mindustry.world.meta.*;

import static eclipsis.content.EBullets.*;
import static eclipsis.content.ESounds.*;
import static mindustry.type.ItemStack.*;

public class EBlocks {
    public static Block
        //turrets
        regression, fulmination,
        //crafters
        glassFurnace, glassMelter, pcbAssembler, diamondPress;

    public static void load(){
        //region turrets
        regression = new ItemTurret("regression"){{
            localizedName = "Regression";
            requirements(Category.turret, with(Items.graphite, 25, Items.titanium, 30));
            ammo(
                Items.copper, regressionBullet, EItems.diamond, regressionDiamondBullet
            );

            recoil = 0.5f;
            shootY = 1f;
            reload = 8f;
            range = 128f;
            shootCone = 16f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 16f;
            shootSound = regressionShoot;

            limitRange();

            drawer = new DrawTurret(){{
                parts.add(new RegionPart("-barrel-r"){{
                    under = true;
                    moveRot = 0;
                    moveX = 0f;
                    moveY = -2f;
                }}, new RegionPart("-barrel-l"){{
                    under = true;
                    moveRot = 0;
                    moveX = 0f;
                    moveY = -2f;
                }});
            }};
        }};
        //endregion

        //region production
        glassFurnace = new GenericCrafter("glass-furnace"){{
            localizedName = "Glass Furnace";
            size = 1;
            itemCapacity = 8;
            craftTime = 30f;
            craftEffect = Fx.smeltsmoke;
            updateEffect = Fx.smoke;

            requirements(Category.crafting, BuildVisibility.shown, with(Items.copper, 25, Items.lead, 50));
            consumeItems(new ItemStack(Items.sand, 8));
            outputItem = new ItemStack(EItems.glass, 2);
        }};

        glassMelter = new GenericCrafter("glass-melter"){{
            localizedName = "Glass Melter";
            size = 2;
            itemCapacity = 16;
            craftTime = 15f;

            requirements(Category.crafting, BuildVisibility.shown, with(Items.copper, 100, Items.lead, 25, Items.titanium, 50));
            consumeItems(new ItemStack(Items.sand, 8));
            outputItem = new ItemStack(EItems.glass, 4);
        }};

        diamondPress = new GenericCrafter("diamond-press"){{
            localizedName = "Diamond Press";
            size = 2;
            itemCapacity = 64;
            craftTime = 60;
            craftEffect = Fx.smoke;

            requirements(Category.crafting, BuildVisibility.shown, with(Items.copper, 25, Items.graphite, 50, Items.titanium, 100));
            consumeItems(new ItemStack(Items.coal, 32));
            consumeLiquids(LiquidStack.with(Liquids.slag, 4f, ELiquids.acid, 2f));
            consumePower(32f);
            outputItem = new ItemStack(EItems.diamond, 1);
        }};
        //endregion
    }
}
