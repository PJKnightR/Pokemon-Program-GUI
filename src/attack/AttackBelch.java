package attack;

import type.Type;
import type.TypePoison;

public class AttackBelch extends Attack{

    public AttackBelch(){
        name = "Belch";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 120;
        description = "The user lets out a damaging belch at the target. The user must eat a held Berry to use this move.";
        accuracy = 90;
        powerpoints = 10;
    }
}
