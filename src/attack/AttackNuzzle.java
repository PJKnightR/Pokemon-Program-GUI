package attack;

import type.Type;
import type.TypeElectric;

public class AttackNuzzle extends Attack{

    public AttackNuzzle(){
        name = "Nuzzle";
        type = Type.getType(TypeElectric.SPOT);
        physical = true;
        power = 20;
        description = "The user attacks by nuzzling its electrified cheeks against the target.  This also leaves the target with paralysis.";
        accuracy = 100;
        powerpoints = 20;
    }
}
