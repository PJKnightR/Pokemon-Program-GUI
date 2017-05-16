package attack;

import type.Type;
import type.TypeElectric;

public class AttackVoltTackle extends Attack{

    public AttackVoltTackle(){
        name = "Volt Tackle";
        type = Type.getType(TypeElectric.SPOT);
        physical = true;
        power = 120;
        description = "The user electrifies itself and charges the target. This also damages the user quite a lot. This attack may leave the target with paralysis.";
        accuracy = 100;
        powerpoints = 15;
    }
}
