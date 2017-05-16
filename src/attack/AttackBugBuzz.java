package attack;

import type.Type;
import type.TypeBug;

public class AttackBugBuzz extends Attack{

    public AttackBugBuzz(){
        name = "Bug Buzz";
        type = Type.getType(TypeBug.SPOT);
        physical = false;
        power = 90;
        description = "The user generates a damaging sound wave by vibration. This may also lower the target's Sp. Def stat.";
        accuracy = 100;
        powerpoints = 10;
    }

}