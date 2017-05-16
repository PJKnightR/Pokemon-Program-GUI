package attack;

import type.Type;
import type.TypeNormal;

public class AttackProtect extends Attack{

    public AttackProtect(){
        name = "Protect";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "Enables the user to evade all attacks. Its chance of failing rises if it is used in succession.";
        accuracy = 0;
        powerpoints = 10;
    }
}
