package eclipsis.content;

import arc.Core;
import arc.math.Mathf;
import mindustry.graphics.Pal;
import mindustry.ui.Bar;
import mindustry.world.blocks.heat.HeatConsumer;
import mindustry.world.blocks.power.PowerGenerator;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.HeatCrafter;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class ConsumeHeatGenerator extends PowerGenerator {

    public float heatRequirement = 10f;
    public float overheatScale = 1f;
    public float maxEfficiency = 4f;

    public ConsumeHeatGenerator(String name) {
        super(name);
    }

    @Override
    public void setBars(){
        super.setBars();

        addBar("heat", (HeatCrafter.HeatCrafterBuild entity) ->
                new Bar(() ->
                        Core.bundle.format("bar.heatpercent", (int)(entity.heat + 0.01f), (int)(entity.efficiencyScale() * 100 + 0.01f)),
                        () -> Pal.lightOrange,
                        () -> entity.heat / heatRequirement));
    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.input, heatRequirement, StatUnit.heatUnits);
        stats.add(Stat.maxEfficiency, (int)(maxEfficiency * 100f), StatUnit.percent);
    }

    public class ConsumeHeatGeneratorBuild extends PowerGenerator.GeneratorBuild implements HeatConsumer{
        //TODO sideHeat could be smooth
        public float[] sideHeat = new float[4];
        public float heat = 0f;

        @Override
        public void updateTile(){
            heat = calculateHeat(sideHeat);

            super.updateTile();
        }

        @Override
        public float heatRequirement(){
            return heatRequirement;
        }

        @Override
        public float[] sideHeat(){
            return sideHeat;
        }

        @Override
        public float efficiencyScale(){
            float over = Math.max(heat - heatRequirement, 0f);
            return Math.min(Mathf.clamp(heat / heatRequirement) + over / heatRequirement * overheatScale, maxEfficiency);
        }
    }
}
