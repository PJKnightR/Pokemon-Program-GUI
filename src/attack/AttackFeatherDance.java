package attack;

import type.Type;
import type.TypeFlying;

public class AttackFeatherDance extends Attack{

    public AttackFeatherDance(){
        name = "Feather Dance";
        type = Type.getType(TypeFlying.SPOT);
        physical = false;
        power = 0;
        description = "The user covers the target's body with a mass of down that harshly lowers its Attack stat.";
        accuracy = 100;
        powerpoints = 15;
    }
}
