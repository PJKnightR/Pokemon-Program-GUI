package attack;

import type.Type;
import type.TypePoison;

public class AttackGunkShot extends Attack{

    public AttackGunkShot(){
        name = "Gunk Shot";
        type = Type.getType(TypePoison.SPOT);
        physical = true;
        power = 120;
        description = "The user shoots filthy garbage at the target to attack. This may also poison the target.";
        accuracy = 80;
        powerpoints = 5;
    }
}
