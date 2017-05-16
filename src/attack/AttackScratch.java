package attack;

import type.Type;
import type.TypeNormal;

public class AttackScratch extends Attack{

    public AttackScratch(){
        name = "Scratch";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 40;
        description = "Hard, pointed, sharp claws rake the target to inflict damage.";
        accuracy = 100;
        powerpoints = 35;
    }
}
