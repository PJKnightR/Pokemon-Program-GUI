package attack;

import type.Type;
import type.TypeElectric;

public class AttackThunderShock extends Attack{

    public AttackThunderShock(){
        name = "Thunder Shock";
        type = Type.getType(TypeElectric.SPOT);
        physical = true;
        power = 40;
        description = "A jolt of electricity crashes down on the target to inflict damage. This may also leave the target with paralysis.";
        accuracy = 100;
        powerpoints = 30;
    }
}
