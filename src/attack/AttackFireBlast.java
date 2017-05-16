package attack;

import type.Type;
import type.TypeFire;

public class AttackFireBlast extends Attack{

    public AttackFireBlast(){
        name = "Fire Blast";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 120;
        description = "The target is attacked with an intense blast of all-consuming fire. This may also leave the target with a burn.";
        accuracy = 85;
        powerpoints = 5;
    }

}