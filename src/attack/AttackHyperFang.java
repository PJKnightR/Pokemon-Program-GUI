package attack;

import type.Type;
import type.TypeNormal;

public class AttackHyperFang extends Attack{

    public AttackHyperFang(){
        name = "Hyper Fang";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 80;
        description = "The user bites hard on the target with its sharp front fangs. This may also make the target flinch.";
        accuracy = 90;
        powerpoints = 15;
    }
}
