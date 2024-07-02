package eclipsis.content;

import arc.graphics.Color;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.ui.Bar;
import mindustry.world.blocks.production.Drill;

public class PrecariousDrill extends Drill {

    public PrecariousDrill(String name) {
        super(name);
    }

    @Override
    public void setBars() {
        super.setBars();
        addBar("Collapse", (PrecariousDrillBuild entity) -> new Bar("Collapse", Color.gray, () -> entity.collapse));
    }

    public class PrecariousDrillBuild extends DrillBuild {

        public float collapse, collapseMultiplier = 0.0001f;

        @Override
        public void updateTile() {
            super.updateTile();

            collapse += collapseMultiplier * delta();
            if (collapse > 1f) {
                kill();
            }
        }

        @Override
        public void write(Writes write) {
            super.write(write);

            write.f(collapse);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);

            collapse = read.f();
        }
    }
}
