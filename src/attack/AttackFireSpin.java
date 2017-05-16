package attack;

import type.Type;
import type.TypeFire;

public class AttackFireSpin extends Attack{

    public AttackFireSpin(){
        name = "Fire Spin";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 35;
        description = "The target becomes trapped within a fierce vortex of fire that rages for four to five turns.";
        accuracy = 85;
        powerpoints = 15;
    }
}
