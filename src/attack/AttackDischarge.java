package attack;

import type.Type;
import type.TypeElectric;

public class AttackDischarge extends Attack{

    public AttackDischarge(){
        name = "Discharge";
        type = Type.getType(TypeElectric.SPOT);
        physical = false;
        power = 80;
        description = "The user strikes everything around it by letting loose a flare of electricity. This may also cause paralysis.";
        accuracy = 100;
        powerpoints = 15;
    }
}
