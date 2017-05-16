package attack;

import type.Type;
import type.TypeElectric;

public class AttackSpark extends Attack{

    public AttackSpark(){
        name = "Spark";
        type = Type.getType(TypeElectric.SPOT);
        physical = false;
        power = 65;
        description = "The user throws an electrically charged tackle at the target. This may also leave the target with paralysis.";
        accuracy = 100;
        powerpoints = 20;
    }
}
