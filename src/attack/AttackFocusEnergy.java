package attack;

import type.Type;
import type.TypeNormal;

public class AttackFocusEnergy extends Attack{

    public AttackFocusEnergy(){
        name = "FocusEnergy";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user takes a deep breath and focuses so that critical hits land more easily.";
        accuracy = 0;
        powerpoints = 30;
    }
}
