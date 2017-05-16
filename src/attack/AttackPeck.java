package attack;

import type.Type;
import type.TypeFlying;

public class AttackPeck extends Attack{

    public AttackPeck(){
        name = "Peck";
        type = Type.getType(TypeFlying.SPOT);
        physical = true;
        power = 35;
        description = "The target is jabbed with a sharply pointed beak or horn";
        accuracy = 100;
        powerpoints = 35;
    }
}
