package eclipsis.content;

import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.ui.Bar;
import mindustry.world.blocks.production.Drill;

public class TippedDrill extends Drill {

    public float baseDrillTime;

    public TippedDrill(String name) {
        super(name);
        baseDrillTime = drillTime;
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("Tip Condition", (TippedDrill.TippedDrillBuild entity) -> new Bar("Tip Condition", EColor.tin, () -> entity.tipCondition));
    }

    public class TippedDrillBuild extends DrillBuild {

        public float tipCondition = 1f, tipConditionMultiplier = 0.0001f;

        @Override
        public void updateTile() {
            super.updateTile();

            tipCondition -= tipConditionMultiplier * delta();
            drillTime = baseDrillTime / tipCondition;
            if (tipCondition < 0.01f) {
                tipCondition = 0.01f;
            }
        }

        @Override
        public void write(Writes write) {
            super.write(write);

            write.f(tipCondition);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);

            tipCondition = read.f();
        }
    }
}
