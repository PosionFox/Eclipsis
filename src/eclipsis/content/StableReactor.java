package eclipsis.content;

import mindustry.world.blocks.power.VariableReactor;

public class StableReactor extends VariableReactor {

    public StableReactor(String name) {
        super(name);

        unstableSpeed = 0f;
    }

    @Override
    public void setBars() {
        super.setBars();

        removeBar("instability");
    }
}
