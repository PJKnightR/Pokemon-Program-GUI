package attack;

import type.Type;
import type.TypeFlying;

public class AttackAerialAce extends Attack{

    public AttackAerialAce(){
        name = "Aerial Ace";
        type = Type.getType(TypeFlying.SPOT);
        physical = true;
        power = 60;
        description = "The user confounds the target with speed, then slashes. This attack never misses.";
        accuracy = 0;
        powerpoints = 20;
    }
}
