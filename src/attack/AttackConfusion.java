package attack;

import type.Type;
import type.TypePsychic;

public class AttackConfusion extends Attack{

    public AttackConfusion(){
        name = "Confusion";
        type = Type.getType(TypePsychic.SPOT);
        physical = false;
        power = 50;
        description = "The target is hit by a weak telekinetic force. This may also confuse the target.";
        accuracy = 100;
        powerpoints = 25;
    }
}
