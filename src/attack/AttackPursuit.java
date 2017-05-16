package attack;

import type.Type;
import type.TypeDark;

public class AttackPursuit extends Attack{

    public AttackPursuit(){
        name = "Pursuit";
        type = Type.getType(TypeDark.SPOT);
        physical = true;
        power = 40;
        description = "The power of this attack move is doubled if it's used on a target that's switching out of battle.";
        accuracy = 100;
        powerpoints = 20;
    }

}