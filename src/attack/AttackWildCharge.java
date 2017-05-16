package attack;

import type.Type;
import type.TypeElectric;

public class AttackWildCharge extends Attack{

    public AttackWildCharge(){
        name = "Wild Charge";
        type = Type.getType(TypeElectric.SPOT);
        physical = true;
        power = 90;
        description = "The user shrouds itself in electricity and smashes into its target. This also damages the user a little.";
        accuracy = 100;
        powerpoints = 15;
    }
}
