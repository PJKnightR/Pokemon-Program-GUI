package attack;

import type.Type;
import type.TypeDark;

public class AttackSuckerPunch extends Attack{

    public AttackSuckerPunch(){
        name = "Sucker Punch";
        type = Type.getType(TypeDark.SPOT);
        physical = true;
        power = 70;
        description = "This move enables the user to attack first. This move fails if the target is not readying an attack.";
        accuracy = 100;
        powerpoints = 5;
    }
}
