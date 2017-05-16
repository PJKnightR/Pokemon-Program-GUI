package attack;

import type.Type;
import type.TypeDark;

public class AttackBite extends Attack{

    public AttackBite(){
        name = "Bite";
        type = Type.getType(TypeDark.SPOT);
        physical = true;
        power = 60;
        description = "The target is bitten with viciously sharp fangs. This may also make the target flinch.";
        accuracy = 100;
        powerpoints = 25;
    }

}