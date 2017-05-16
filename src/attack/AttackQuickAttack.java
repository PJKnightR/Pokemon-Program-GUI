package attack;

import type.Type;
import type.TypeNormal;

public class AttackQuickAttack extends Attack{

    public AttackQuickAttack(){
        name = "Quick Attack";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 40;
        description = "The user lunges at the target at a speed that makes it almost invisible. This move always goes first.";
        accuracy = 100;
        powerpoints = 30;
    }

}