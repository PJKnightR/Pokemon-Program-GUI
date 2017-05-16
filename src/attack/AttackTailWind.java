package attack;

import type.Type;
import type.TypeFlying;

public class AttackTailWind extends Attack{

    public AttackTailWind(){
        name = "TailWind";
        type = Type.getType(TypeFlying.SPOT);
        physical = false;
        power = 0;
        description = "The user whips up a turbulent whirlwind that ups the Speed stat of the user and its allies for four turns.";
        accuracy = 0;
        powerpoints = 15;
    }
}
