package attack;

import type.Type;
import type.TypePoison;

public class AttackCoil extends Attack{

    public AttackCoil(){
        name = "Coil";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 0;
        description = "The user coils up and concentrates. This raises its Attack and Defense stats as well as its accuracy.";
        accuracy = 0;
        powerpoints = 20;
    }
}
