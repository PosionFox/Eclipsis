package eclipsis.content;

import mindustry.game.Team;
import mindustry.world.Tile;
import mindustry.world.blocks.production.GenericCrafter;

public class OnAcidCrafter extends GenericCrafter {

    public OnAcidCrafter(String name) {
        super(name);
    }

    @Override
    public boolean canPlaceOn(Tile tile, Team team, int rotation) {
        return tile.floor() == EBlocks.acid.asFloor() || tile.floor() == EBlocks.acidDeep.asFloor();
    }
}
