package attack;

import type.Type;
import type.TypeNormal;

public class AttackFeint extends Attack{

    public AttackFeint(){
        name = "Feint";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 30;
        description = "This attack hits a target using a move such as Protect or Detect. This also lifts the effects of those moves.";
        accuracy = 100;
        powerpoints = 10;
    }
}
