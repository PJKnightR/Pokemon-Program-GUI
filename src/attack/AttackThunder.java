package attack;

import type.Type;
import type.TypeElectric;

public class AttackThunder extends Attack{

    public AttackThunder(){
        name = "Thunder";
        type = Type.getType(TypeElectric.SPOT);
        physical = false;
        power = 110;
        description = "A wicked thunderbolt is dropped on the target to inflict damage. This may also leave the target with paralysis.";
        accuracy = 70;
        powerpoints = 10;
    }
}
