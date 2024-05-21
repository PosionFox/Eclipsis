package eclipsis.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class EItems {
    public static Item
        glass, pcb, diamond;

    public static void load(){
        glass = new Item("glass", Color.cyan){{
            localizedName = "Glass";
            description = "Worse than Metaglass but still useful.";
        }};
        diamond = new Item("diamond", Color.cyan){{
            localizedName = "Diamond";
            description = "A beautiful gem.";
        }};
    }
}
