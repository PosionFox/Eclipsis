package eclipsis.content;

import arc.graphics.Color;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class ELiquids {
    public static Liquid
        acid, acidGas, petroleum, methane, biogas, resin;

    public static void load(){
        acid = new Liquid("acid", EColor.acid){{
            localizedName = "Acid";
        }};
        acidGas = new Liquid("acid-gas", EColor.acid) {{
            localizedName = "Acid Gas";
            gas = true;
            temperature = 0.75f;
        }};
        petroleum = new Liquid("petroleum", Color.black){{
            localizedName = "Petroleum";
            viscosity = 0.75f;
            flammability = 1.2f;
            explosiveness = 1.2f;
            heatCapacity = 0.7f;
            barColor = Color.valueOf("6b675f");
            effect = StatusEffects.tarred;
            boilPoint = 0.65f;
            gasColor = Color.grays(0.4f);
            canStayOn.add(Liquids.water);
        }};
        methane = new Liquid("methane", EColor.methane){{
            localizedName = "Methane";
            gas = true;
            flammability = 2f;
        }};
        biogas = new Liquid("biogas", EColor.biogas){{
            localizedName = "Biogas";
            gas = true;
            flammability = 1.5f;
        }};
        resin = new Liquid("resin", EColor.resin) {{
            localizedName = "Resin";
            viscosity = 0.75f;
        }};
    }
}
