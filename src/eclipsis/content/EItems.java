package eclipsis.content;

import arc.graphics.Color;
import arc.struct.Seq;
import mindustry.type.Item;

import static mindustry.content.Items.*;

public class EItems {
    public static Item
        stone, glass, iron, pcb, diamond, gold, adamantite, silver, tin, lignite, resin;

    public static final Seq<Item> chrysidirosItems = new Seq<>();

    public static void load(){
        stone = new Item("stone", Color.gray){{
            localizedName = "Stone";
            description = "A very primitive resource";
        }};
        glass = new Item("glass", Color.cyan){{
            localizedName = "Glass";
            description = "Worse than Metaglass but still useful.";
        }};
        diamond = new Item("diamond", Color.cyan){{
            localizedName = "Diamond";
            description = "A beautiful gem.";
        }};
        iron = new Item("iron", Color.lightGray){{
            localizedName = "Iron";
            description = "A multi-purpose metal.";
        }};
        tin = new Item("tin", EColor.tin){{
            localizedName = "Tin";
            description = "A soft metal.";
        }};
        silver = new Item("silver", Color.white){{
            localizedName = "Silver";
            description = "A shiny metal.";
        }};
        gold = new Item("gold", Color.gold){{
            localizedName = "Gold";
            description = "A shiny and rather soft metal.";
        }};
        adamantite = new Item("adamantite", Color.lime){{
            localizedName = "Adamantite";
            description = "A strange metal, some say it's unbreakable.";
        }};
        pcb = new Item("pcb", Color.lime){{
            localizedName = "PCB";
            description = "A printed circuit board";
        }};
        lignite = new Item("lignite", Color.green){{
            localizedName = "Lignite";
            description = "A flammable fuel source";
            flammability = 1f;
        }};

        chrysidirosItems.addAll(
            stone, glass, diamond, iron, gold, pcb, adamantite, tin, silver, lignite
        );
    }
}
