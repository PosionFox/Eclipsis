package eclipsis.content;

import arc.graphics.Color;
import arc.util.Reflect;
import mindustry.content.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.game.Team;
import mindustry.gen.Sounds;
import mindustry.graphics.CacheLayer;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.Conveyor;
import mindustry.world.blocks.distribution.Duct;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.heat.HeatProducer;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.consumers.ConsumeItemFlammable;
import mindustry.world.consumers.ConsumeLiquid;
import mindustry.world.consumers.ConsumePayloads;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static eclipsis.content.EBullets.*;
import static eclipsis.content.ESounds.*;
import static mindustry.type.ItemStack.*;

public class EBlocks {
    public static Block
        //environment
        acidicStoneFloor, basaltFloor, acid, acidDeep, petroleum,
        //ore
        oreStone, oreTin, oreIron, oreGold, oreAdamantite, oreDiamond, oreSilver, oreLignite,
        //storage
        coreBit,
        //turrets
        regression, fulmination, dissension,
        //distribution
        tinDuct,
        //liquid
        alloyPump, alloyConduit,
        //power
        chemfuelGenerator, acidGasTurbine, alloyPowerNode, alloyPowerNodeLarge,
        //production
        glassFurnace, glassMelter, pcbAssembler, diamondPress, mechanicalGasExtractor, hydraulicFracturer, acidBoiler,
        primitiveDrill, tinDrill, ironDrill, precisionDrill, diamondDrill, resinCultivator;

    public static void load() {
        //region environment
        acidicStoneFloor = new Floor("acidic-stone-floor") {{
            localizedName = "Acidic Stone Floor";
        }};
        basaltFloor = new Floor("basalt-floor") {{
            localizedName = "Basalt Floor";
        }};
        acid = new Floor("acid") {{
            speedMultiplier = 0.8f;
            variants = 1;
            liquidDrop = ELiquids.acid;
            liquidMultiplier = 1.5f;
            isLiquid = true;
            status = EStatusEffects.corrosion;
            statusDuration = 60f;
            drownTime = 200f;
            albedo = 0.9f;
            supportsOverlay = true;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.light, 2f);
            lightRadius = 16f;
            lightColor = Color.acid;
        }};
        acidDeep = new Floor("deep-acid") {{
            speedMultiplier = 0.6f;
            variants = 1;
            liquidDrop = ELiquids.acid;
            liquidMultiplier = 2f;
            isLiquid = true;
            status = EStatusEffects.corrosion;
            statusDuration = 120f;
            drownTime = 100f;
            albedo = 0.9f;
            supportsOverlay = true;
            cacheLayer = CacheLayer.water;
            attributes.set(Attribute.light, 2f);
            lightRadius = 16f;
            lightColor = Color.acid;
        }};
        petroleum = new Floor("petroleum"){{
            drownTime = 230f;
            status = StatusEffects.tarred;
            statusDuration = 240f;
            speedMultiplier = 0.19f;
            variants = 0;
            liquidDrop = ELiquids.petroleum;
            isLiquid = true;
            cacheLayer = CacheLayer.tar;
        }};
        //endregion

        //region ore
        oreStone = new OreBlock("ore-stone") {{
            variants = 3;
            itemDrop = EItems.stone;
            localizedName = itemDrop.localizedName;
            itemDrop.hardness = 1;
        }};
        oreTin = new OreBlock("ore-tin") {{
            variants = 3;
            itemDrop = EItems.tin;
            localizedName = itemDrop.localizedName;
            itemDrop.hardness = 2;
        }};
        oreLignite = new OreBlock("ore-lignite") {{
            variants = 3;
            itemDrop = EItems.lignite;
            itemDrop.hardness = 2;
            localizedName = itemDrop.localizedName;
        }};
        oreGold = new OreBlock("ore-gold") {{
            variants = 3;
            itemDrop = EItems.gold;
            localizedName = itemDrop.localizedName;
            itemDrop.hardness = 2;
        }};
        oreIron = new OreBlock("ore-iron") {{
            variants = 3;
            itemDrop = EItems.iron;
            localizedName = itemDrop.localizedName;
            itemDrop.hardness = 3;
        }};
        oreSilver = new OreBlock("ore-silver") {{
            variants = 3;
            itemDrop = EItems.silver;
            localizedName = itemDrop.localizedName;
            itemDrop.hardness = 3;
        }};
        oreAdamantite = new OreBlock("ore-adamantite") {{
            variants = 3;
            itemDrop = EItems.adamantite;
            itemDrop.hardness = 4;
            localizedName = itemDrop.localizedName;
        }};
        oreDiamond = new OreBlock("ore-diamond") {{
            variants = 3;
            itemDrop = EItems.diamond;
            itemDrop.hardness = 5;
            localizedName = itemDrop.localizedName;
        }};
        //endregion

        //region storage
        coreBit = new CoreBlock("core-bit") {{
            localizedName = "Core: Bit";
            requirements(Category.effect, BuildVisibility.editorOnly, with(EItems.iron, 1000, EItems.diamond, 100));
            alwaysUnlocked = true;
            isFirstTier = true;
            unitType = EUnitTypes.delta;
            health = 1500;
            itemCapacity = 5000;
            size = 3;
            unitCapModifier = 10;
        }};
        //endregion

        //region turrets
        regression = new ItemTurret("regression") {{
            localizedName = "Regression";
            requirements(Category.turret, BuildVisibility.shown, with(EItems.iron, 50));
            ammo(
                    EItems.tin, regressionBullet, EItems.diamond, regressionDiamondBullet
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
            researchCost = with(EItems.iron, 45);

            limitRange();

            shoot = new ShootAlternate(4f);
            recoils = 2;

            drawer = new DrawTurret() {{
                parts.add(new RegionPart("-barrel-r") {{
                    under = true;
                    moveRot = 0;
                    moveX = 0f;
                    moveY = -2f;
                    progress = PartProgress.recoil;
                    recoilIndex = 0;
                }}, new RegionPart("-barrel-l") {{
                    under = true;
                    moveRot = 0;
                    moveX = 0f;
                    moveY = -2f;
                    progress = PartProgress.recoil;
                    recoilIndex = 1;
                }});
            }};
        }};

        fulmination = new LaserTurret("fulmination") {{
            localizedName = "Fulmination";
            requirements(Category.turret, BuildVisibility.shown, with(EItems.stone, 5));

            recoil = 0.5f;
            shootY = 8f;
            reload = 256f;
            range = 90f;
            shootCone = 16f;
            ammoUseEffect = Fx.casing1;
            health = 250;
            inaccuracy = 2f;
            rotateSpeed = 16f;
            moveWhileCharging = false;

            shoot.firstShotDelay = 60f;
            shootSound = fulminationShoot;
            researchCost = with(EItems.stone, 45);

            shootType = fulminationBullet;
            consumePower(4f);

            drawer = new DrawTurret() {{
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    moveRot = 0;
                    moveX = 0f;
                    moveY = -2f;
                    progress = PartProgress.recoil;
                }});
            }};
        }};

        dissension = new EItemTurret("dissension") {{
            localizedName = "Dissension";
            requirements(Category.turret, BuildVisibility.shown, with(EItems.stone, 5));
            ammo(
                    EItems.adamantite, dissensionBullet
            );
            size = 2;
            recoil = 0.5f;
            shootY = 1f;
            reload = 180f;
            range = 333f;
            shootCone = 16f;
            ammoUseEffect = Fx.casing1;
            inaccuracy = 1f;
            rotateSpeed = 4f;
            shootSound = dissensionShoot;

            limitRange();

            drawer = new DrawTurret() {{
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    moveRot = 0;
                    moveX = 0f;
                    moveY = -2f;
                    progress = PartProgress.reload;
                }});
            }};
        }};
        //endregion

        //region distribution
        tinDuct = new Duct("tin-duct") {{
            localizedName = "Tin duct";
            requirements(Category.distribution, BuildVisibility.shown, with(EItems.tin, 1));
            speed = 10f;
            buildCostMultiplier = 2f;
        }};
        //endregion

        //liquid
        alloyPump = new Pump("alloy-pump") {{
            localizedName = "Alloy Pump";
            requirements(Category.liquid, BuildVisibility.shown, with(EItems.tin, 12, EItems.iron, 12));
            pumpAmount = 9f / 60f;
            squareSprite = false;
        }};
        alloyConduit = new Conduit("alloy-conduit") {{
            localizedName = "Alloy Conduit";
            requirements(Category.liquid, BuildVisibility.shown, with(EItems.glass, 1, EItems.tin, 1));
        }};
        //endregion

        //region power
        acidGasTurbine = new StableReactor("acid-gas-turbine") {{
            localizedName = "Acid Gas Turbine";
            description = "A special turbine that turns acid gas into power";
            requirements(Category.power, BuildVisibility.shown, with(EItems.tin, 80, EItems.iron, 55));
            powerProduction = 2.5f;
            size = 2;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.1f;
            squareSprite = false;

            consume(new ConsumeLiquid(ELiquids.acidGas, 0.1f));

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(){{
                midColor = flameColor = Color.green;
                circleStroke = 1.5f;
                circleSpace = 2f;
            }}, new DrawRegion("-rotator", 2f), new DrawDefault(), new DrawRegion("-top"),
                new DrawHeatInput("-heat"));
        }};
        chemfuelGenerator = new ConsumeGenerator("chemfuel-generator") {{
            localizedName = "Chemfuel Generator";
            requirements(Category.power, BuildVisibility.shown, with(EItems.tin, 25, EItems.iron, 40));
            powerProduction = 2f;
            itemDuration = 60f;
            researchCost = with(Items.coal, 100);

            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.1f;
            generateEffect = Fx.generatespark;

            consume(new ConsumeItemFlammable());

            drawer = new DrawMulti(new DrawDefault(), new DrawWarmupRegion());
        }};
        alloyPowerNode = new PowerNode("alloy-power-node") {{
            localizedName = "Alloy Power Node";
            requirements(Category.power, with(EItems.tin, 4, EItems.iron, 4));
            maxNodes = 16;
            laserRange = 12f;
        }};
        alloyPowerNodeLarge = new PowerNode("alloy-power-node-large"){{
            localizedName = "Alloy Power Node Large";
            requirements(Category.power, with(EItems.tin, 8, EItems.iron, 8, EItems.gold, 4));
            size = 2;
            maxNodes = 32;
            laserRange = 24f;
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
            researchCost = with(EItems.iron, 50, EItems.tin, 50);

            requirements(Category.crafting, BuildVisibility.shown, with(EItems.tin, 25, EItems.iron, 50));
            consumeItems(new ItemStack(Items.sand, 8));
            outputItem = new ItemStack(EItems.glass, 2);
        }};

        glassMelter = new GenericCrafter("glass-melter"){{
            localizedName = "Glass Melter";
            size = 2;
            itemCapacity = 16;
            craftTime = 15f;
            craftEffect = Fx.smeltsmoke;
            updateEffect = Fx.smoke;

            requirements(Category.crafting, BuildVisibility.shown, with(EItems.tin, 100, EItems.iron, 25, EItems.adamantite, 50));
            consumeItems(new ItemStack(Items.sand, 8));
            outputItem = new ItemStack(EItems.glass, 4);
        }};

        diamondPress = new GenericCrafter("diamond-press"){{
            localizedName = "Diamond Press";
            size = 2;
            itemCapacity = 64;
            craftTime = 60f;
            craftEffect = Fx.smoke;

            requirements(Category.crafting, BuildVisibility.shown, with(EItems.tin, 25, Items.graphite, 50, EItems.adamantite, 100));
            consumeItems(new ItemStack(Items.coal, 32));
            consumeLiquids(LiquidStack.with(Liquids.slag, 4f, ELiquids.acid, 2f));
            consumePower(32f);
            outputItem = new ItemStack(EItems.diamond, 1);
        }};

        pcbAssembler = new GenericCrafter("pcb-assembler"){{
            localizedName = "PCB Assembler";
            size = 2;
            itemCapacity = 16;
            craftTime = 120f;
            craftEffect = Fx.sparkExplosion;

            requirements(Category.crafting, BuildVisibility.shown, with(EItems.tin, 35, EItems.iron, 45, EItems.glass, 25));
            consumeItems(ItemStack.with(EItems.gold, 4, EItems.glass, 4));
            consumeLiquid(ELiquids.resin, 0.4f);
            consumePower(25f / 60f);
            outputItem = new ItemStack(EItems.pcb, 1);
        }};

        acidBoiler = new HeatProducer("acid-boiler"){{
            localizedName = "Acid Boiler";
            description = "Boils acid and turns it into acidic gas, generates heat.";
            requirements(Category.crafting, BuildVisibility.shown, with(EItems.iron, 20, EItems.tin, 20));
            size = 2;
            squareSprite = false;

            consumeLiquid(ELiquids.acid, 4f / 60f);
            heatOutput = 200f;
            outputLiquids = LiquidStack.with(ELiquids.acidGas, 16f / 60f);

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawBubbles(){{
                color = Color.lime;
            }}, new DrawDefault(), new DrawHeatOutput());
        }};

        mechanicalGasExtractor = new OnAcidCrafter("mechanical-gas-extractor"){{
            localizedName = "Mechanical Gas Extractor";
            description = "Extracts natural gases from the underground using acid to melt the rocks";
            requirements(Category.production, BuildVisibility.shown, with(EItems.iron, 50, EItems.glass, 25));
            size = 3;
            craftTime = 25f;
            rotate = true;
            invertFlip = true;
            itemCapacity = 0;
            liquidCapacity = 64f;
            placeableLiquid = true;

            ambientSound = Sounds.electricHum;
            ambientSoundVolume = 0.1f;

            regionRotated1 = 3;
            outputLiquids = LiquidStack.with(ELiquids.methane, 6f / 60f, ELiquids.biogas, 2f / 60f);
            liquidOutputDirections = new int[]{1, 3};

            drawer = new DrawMulti(new DrawRegion(), new DrawLiquidOutputs());
        }};

        primitiveDrill = new PrecariousDrill("primitive-drill"){{
            localizedName = "Primitive Drill";
            requirements(Category.production, BuildVisibility.shown, with(EItems.stone, 30));
            tier = 2;
            drillTime = 400f;
            size = 1;
            squareSprite = false;
            researchCost = with(EItems.stone, 55);
        }};
        tinDrill = new TippedDrill("tin-drill") {{
            localizedName = "Tin Drill";
            requirements(Category.production, BuildVisibility.shown, with(EItems.tin, 15));
            tier = 3;
            drillTime = 500f;
            size = 2;
            squareSprite = false;
            researchCostMultiplier = 0.1f;
        }};
        ironDrill = new Drill("iron-drill"){{
            localizedName = "Iron Drill";
            requirements(Category.production, BuildVisibility.shown, with(EItems.iron, 25));
            tier = 4;
            drillTime = 350f;
            size = 2;
            researchCost = with(EItems.iron, 100);
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};
        precisionDrill = new Drill("precision-drill"){{
            localizedName = "Precision Drill";
            requirements(Category.production, BuildVisibility.shown, with(EItems.iron, 15, EItems.pcb, 3));
            tier = 5;
            drillTime = 150f;
            size = 1;
            squareSprite = false;
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};
        diamondDrill = new Drill("diamond-drill"){{
            localizedName = "Diamond Drill";
            requirements(Category.production, BuildVisibility.shown, with(EItems.iron, 75, EItems.diamond, 10, EItems.pcb, 5));
            tier = 6;
            drillTime = 300f;
            size = 3;
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};

        resinCultivator = new GenericCrafter("resin-cultivator") {{
            localizedName = "Resin Cultivator";
            description = "Cultivates plants and harvests their resins.";
            requirements(Category.production, BuildVisibility.shown, with(EItems.tin, 25, EItems.glass, 35));
            size = 2;
            craftTime = 120f;

            consumeLiquid(ELiquids.petroleum, 0.05f).boost();
            outputLiquid = new LiquidStack(ELiquids.resin, 0.1f);

            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(ELiquids.petroleum),
                    new DrawDefault(),
                    new DrawCultivator(),
                    new DrawRegion("-top")
            );
        }};
        //endregion
    }
}
