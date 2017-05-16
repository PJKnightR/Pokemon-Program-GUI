package attack;

import type.Type;
import type.TypeBug;

public class AttackPinMissle extends Attack{

    public AttackPinMissle(){
        name = "Pin Missle";
        type = Type.getType(TypeBug.SPOT);
        physical = true;
        power = 20;
        description = "Sharp spikes are shot at the target in rapid succession. They hit two to five times in a row";
        accuracy = 95;
        powerpoints = 20;
    }
}
