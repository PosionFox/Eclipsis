package eclipsis.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class EItems {
    public static Item
        glass, pcb;

    public static void load(){
        glass = new Item("glass", Color.cyan){{
            localizedName = "Glass";
            description = "Worse than Metaglass but still useful.";
        }};
    }
}
