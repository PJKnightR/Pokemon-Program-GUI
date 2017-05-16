package attack;

import type.Type;
import type.TypeElectric;

public class AttackThunderWave extends Attack{

    public AttackThunderWave(){
        name = "Thunder Wave";
        type = Type.getType(TypeElectric.SPOT);
        physical = false;
        power = 0;
        description = "The user launches a weak jolt of electricity that paralyzes the target.";
        accuracy = 90;
        powerpoints = 20;
    }
}
