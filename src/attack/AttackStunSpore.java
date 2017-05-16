package attack;

import type.Type;
import type.TypeGrass;

public class AttackStunSpore extends Attack{

    public AttackStunSpore(){
        name = "Stun Spore";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 0;
        description = "The user scatters a cloud of numbing powder that paralyzes the target.";
        accuracy = 75;
        powerpoints = 30;
    }
}
