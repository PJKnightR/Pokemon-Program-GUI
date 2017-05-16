package attack;

import type.Type;
import type.TypeNormal;

public class AttackFuryAttack extends Attack{

    public AttackFuryAttack(){
        name = "Fury Attack";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 45;
        description = "The target is jabbed repeatedly with a horn or beak two to five times in a row.";
        accuracy = 85;
        powerpoints = 20;
    }
}
