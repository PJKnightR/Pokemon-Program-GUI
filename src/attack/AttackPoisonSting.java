package attack;

import type.Type;
import type.TypePoison;

public class AttackPoisonSting extends Attack{

    public AttackPoisonSting(){
        name = "Poison Sting";
        type = Type.getType(TypePoison.SPOT);
        physical = true;
        power = 15;
        description = "The user stabs the target with a poisonous stinger. This may also poison the target.";
        accuracy = 100;
        powerpoints = 35;
    }

}