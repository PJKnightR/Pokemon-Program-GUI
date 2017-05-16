package attack;

import type.Type;
import type.TypeBug;

public class AttackFellStinger extends Attack{

    public AttackFellStinger(){
        name = "Fell Stinger";
        type = Type.getType(TypeBug.SPOT);
        physical = true;
        power = 30;
        description = "When the user knocks out a target with this move, the user's Attack stat rises drastically.";
        accuracy = 100;
        powerpoints = 25;
    }

}