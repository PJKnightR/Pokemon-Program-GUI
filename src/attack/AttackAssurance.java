package attack;

import type.Type;
import type.TypeDark;

public class AttackAssurance extends Attack{

    public AttackAssurance(){
        name = "Assurance";
        type = Type.getType(TypeDark.SPOT);
        physical = true;
        power = 60;
        description = "If the target has already taken some damage in the same turn, this attack's power is doubled.";
        accuracy = 100;
        powerpoints = 10;
    }
}
