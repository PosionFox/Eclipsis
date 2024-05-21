package eclipsis.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class ELiquids {
    public static Liquid
        acid;

    public static void load(){
        acid = new Liquid("acid", Color.lime){{
            localizedName = "Acid";
        }};
    }
}
