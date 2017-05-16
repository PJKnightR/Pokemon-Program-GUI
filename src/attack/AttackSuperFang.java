package attack;

import type.Type;
import type.TypeNormal;

public class AttackSuperFang extends Attack{

    public AttackSuperFang(){
        name = "Super Fang";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 1;
        description = "The user chomps hard on the target with its sharp front fangs.  This cuts the target's HP in half.";
        accuracy = 90;
        powerpoints = 10;
    }
}
