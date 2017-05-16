package attack;

import type.Type;
import type.TypePoison;

public class AttackAcidSpray extends Attack{

    public AttackAcidSpray(){
        name = "Acid Spray";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 40;
        description = "The user spits fluid that works to melt the target. This harshly lowers the target's Sp. Def stat.";
        accuracy = 100;
        powerpoints = 20;
    }
}
