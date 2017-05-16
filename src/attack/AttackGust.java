package attack;

import type.Type;
import type.TypeFlying;

public class AttackGust extends Attack{

    public AttackGust(){
        name = "Gust";
        type = Type.getType(TypeFlying.SPOT);
        physical = false;
        power = 40;
        description = "A gust of wind is whipped up by wings and launched at the target to inflict damage.";
        accuracy = 100;
        powerpoints = 35;
    }

}