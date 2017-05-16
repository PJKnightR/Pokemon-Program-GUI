package attack;

import type.Type;
import type.TypeNormal;

public class AttackRage extends Attack{

    public AttackRage(){
        name = "Rage";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 20;
        description = "As long as this move is in use, the power of rage raises the Attack stat each time the user is hit in battle.";
        accuracy = 100;
        powerpoints = 20;
    }
}
