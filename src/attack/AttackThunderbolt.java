package attack;

import type.Type;
import type.TypeElectric;

public class AttackThunderbolt extends Attack{

    public AttackThunderbolt(){
        name = "Thunderbolt";
        type = Type.getType(TypeElectric.SPOT);
        physical = false;
        power = 90;
        description = "A strong electric blast crashes down on the target. This may also leave the target with paralysis.";
        accuracy = 100;
        powerpoints = 15;
    }
}
