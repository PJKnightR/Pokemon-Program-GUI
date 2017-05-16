package attack;

import type.Type;
import type.TypeBug;

public class AttackBugBite extends Attack{

    public AttackBugBite(){
        name = "Bug Bite";
        type = Type.getType(TypeBug.SPOT);
        physical = true;
        power = 60;
        description = "The user bites the target. If the target is holding a Berry, the user eats it and gains its effect.";
        accuracy = 100;
        powerpoints = 20;
    }

}