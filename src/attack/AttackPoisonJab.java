package attack;

import type.Type;
import type.TypePoison;

public class AttackPoisonJab extends Attack{

    public AttackPoisonJab(){
        name = "Poison Jab";
        type = Type.getType(TypePoison.SPOT);
        physical = true;
        power = 80;
        description = "The target is stabbed with a tentacle or arm steeped in poison. This may also poison the target.";
        accuracy = 100;
        powerpoints = 20;
    }

}