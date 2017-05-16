package attack;

import type.Type;
import type.TypeFire;

public class AttackFlamethrower extends Attack{

    public AttackFlamethrower(){
        name = "Flamethrower";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 90;
        description = "The target is scorched with an intense blast of fire. This may also leave the target with a burn.";
        accuracy = 100;
        powerpoints = 15;
    }

}