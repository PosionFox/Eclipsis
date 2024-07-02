package eclipsis.content;

import arc.struct.*;
import mindustry.content.Items;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

import static eclipsis.content.EBlocks.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.SectorPresets.craters;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.UnitTypes.*;

public class ETechTree {
    public static void load(){
        EPlanets.chrysidiros.techTree = nodeRoot("chrysidiros", coreBit, () -> {
            node(regression, () -> {

            });

            node(primitiveDrill, () -> {
                node(ironDrill, () -> {
                    node(precisionDrill, () -> {
                        node(diamondDrill, () -> {

                        });
                    });
                });
            });

            node(chemfuelGenerator, () -> {

            });

            node(glassFurnace, () -> {
                node(pcbAssembler, () -> {

                });
                node(glassMelter, () -> {

                });
                node(diamondPress, () -> {

                });
            });

            node(tinDuct, () -> {

            });

            nodeProduce(EItems.stone, () -> {
                nodeProduce(EItems.lignite, () -> {

                });
                nodeProduce(EItems.iron, () -> {
                    nodeProduce(ELiquids.acid, () -> {

                    });
                    nodeProduce(EItems.glass, () -> {

                    });
                });
            });
        });
    }
}
