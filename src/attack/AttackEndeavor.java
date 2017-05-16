package attack;

import type.Type;
import type.TypeNormal;

public class AttackEndeavor extends Attack{

    public AttackEndeavor(){
        name = "Endeavor";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 1;
        description = "This attack move cuts down the target's HP to equal the user's HP.";
        accuracy = 100;
        powerpoints = 5;
    }
}
