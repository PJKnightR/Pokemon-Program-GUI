package attack;

import type.Type;
import type.TypeFire;

public class AttackFlareBlitz extends Attack{

    public AttackFlareBlitz(){
        name = "Flare Blitz";
        type = Type.getType(TypeFire.SPOT);
        physical = true;
        power = 120;
        description = "The user cloaks itself in fire and charges the target.  This also damages the user quite a lot.  This attack may leave the target with a burn.";
        accuracy = 100;
        powerpoints = 15;
    }
}
