package attack;

import type.Type;
import type.TypeNormal;

public class AttackDrillRun extends Attack{

    public AttackDrillRun(){
        name = "Drill Run";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 80;
        description = "The user crashes into its target while rotating its body like a drill. Critical hits land more easily.";
        accuracy = 95;
        powerpoints = 10;
    }
}
