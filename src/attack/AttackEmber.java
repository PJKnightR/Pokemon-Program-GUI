package attack;

import type.Type;
import type.TypeFire;

public class AttackEmber extends Attack{

    public AttackEmber(){
        name = "Ember";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 40;
        description = "The target is attacked with small flames. This may also leave the target with a burn.";
        accuracy = 100;
        powerpoints = 25;
    }

}