package attack;

import type.Type;
import type.TypeSteel;

public class AttackSteelWing extends Attack{

    public AttackSteelWing(){
        name = "Steel Wing";
        type = Type.getType(TypeSteel.SPOT);
        physical = true;
        power = 70;
        description = "The target is hit with wings of steel. This may also raise the user's Defense stat.";
        accuracy = 90;
        powerpoints = 25;
    }

}