package attack;

import type.Type;
import type.TypeGrass;

public class AttackSleepPowder extends Attack{

    public AttackSleepPowder(){
        name = "Sleep Powder";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 0;
        description = "The user scatters a big cloud of sleep-inducing dust around the target.";
        accuracy = 75;
        powerpoints = 15;
    }
}
