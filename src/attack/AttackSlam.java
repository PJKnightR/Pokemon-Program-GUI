package attack;

import type.Type;
import type.TypeNormal;

public class AttackSlam extends Attack{

    public AttackSlam(){
        name = "Slam";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 80;
        description = "The target is slammed with a long tail, vines, or the like to inflict damage.";
        accuracy = 75;
        powerpoints = 20;
    }
}
