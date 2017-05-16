package attack;

import type.Type;
import type.TypeFlying;

public class AttackRoost extends Attack{

    public AttackRoost(){
        name = "Roost";
        type = Type.getType(TypeFlying.SPOT);
        physical = false;
        power = 0;
        description = "The user lands and rests its body. It restores the user's HP by up to half of its max HP.";
        accuracy = 0;
        powerpoints = 10;
    }
}
