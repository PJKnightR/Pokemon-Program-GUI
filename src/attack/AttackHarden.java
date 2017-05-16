package attack;

import type.Type;
import type.TypeNormal;

public class AttackHarden extends Attack{

    public AttackHarden(){
        name = "Harden";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user stiffens all the muscles in its body to raise its Defense stat.";
        accuracy = 0;
        powerpoints = 30;
    }
}
