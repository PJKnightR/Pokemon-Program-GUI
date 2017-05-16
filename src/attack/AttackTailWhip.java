package attack;

import type.Type;
import type.TypeNormal;

public class AttackTailWhip extends Attack{

    public AttackTailWhip(){
        name = "Tail Whip";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user wags its tail cutely, making opposing Pokemon less wary and lowering their Defense stat.";
        accuracy = 100;
        powerpoints = 30;
    }
}
