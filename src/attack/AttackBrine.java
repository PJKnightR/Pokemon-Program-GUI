package attack;

import type.Type;
import type.TypeWater;

public class AttackBrine extends Attack{

    public AttackBrine(){
        name = "Brine";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 65;
        description = "If the target's HP is half or less, this attack will hit with double the power.";
        accuracy = 100;
        powerpoints = 10;
    }

}