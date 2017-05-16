package attack;

import type.Type;
import type.TypeFlying;

public class AttackAirSlash extends Attack{

    public AttackAirSlash(){
        name = "Air Slash";
        type = Type.getType(TypeFlying.SPOT);
        physical = false;
        power = 75;
        description = "The user attacks with a blade of air that slices even the sky. This may also make the target flinch.";
        accuracy = 95;
        powerpoints = 15;
    }

}