package attack;

import type.Type;
import type.TypeFlying;

public class AttackHurricane extends Attack{

    public AttackHurricane(){
        name = "Hurricane";
        type = Type.getType(TypeFlying.SPOT);
        physical = false;
        power = 110;
        description = "The user attacks by wrapping its opponent in a fierce wind that flies up into the sky. This may also confuse the target.";
        accuracy = 70;
        powerpoints = 10;
    }

}