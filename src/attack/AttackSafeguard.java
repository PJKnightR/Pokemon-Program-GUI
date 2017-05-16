package attack;

import type.Type;
import type.TypeNormal;

public class AttackSafeguard extends Attack{

    public AttackSafeguard(){
        name = "Safeguard";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user creates a protective field that prevents status conditions for five turns.";
        accuracy = 0;
        powerpoints = 25;
    }
}
