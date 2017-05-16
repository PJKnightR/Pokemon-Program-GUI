package attack;

import type.Type;
import type.TypeNormal;

public class AttackTakeDown extends Attack{

    public AttackTakeDown(){
        name = "Take Down";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 90;
        description = "A reckless, full-body charge attack for slamming into the target. This also damages the user a little.";
        accuracy = 85;
        powerpoints = 20;
    }
}
