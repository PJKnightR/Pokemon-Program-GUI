package attack;

import type.Type;
import type.TypeNormal;

public class AttackTackle extends Attack{

    public AttackTackle(){
        name = "Tackle";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 50;
        description = "A physical attack in which the user charges and slams into the target with its whole body.";
        accuracy = 100;
        powerpoints = 35;
    }

}