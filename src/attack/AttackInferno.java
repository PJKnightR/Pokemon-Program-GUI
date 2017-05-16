package attack;

import type.Type;
import type.TypeFire;

public class AttackInferno extends Attack{

    public AttackInferno(){
        name = "Inferno";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 100;
        description = "The user attacks by engulfing the target in an intense fire. This leaves the target with a burn.";
        accuracy = 50;
        powerpoints = 5;
    }
}
