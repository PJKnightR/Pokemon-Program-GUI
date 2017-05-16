package attack;

import type.Type;
import type.TypeWater;

public class AttackHydroPump extends Attack{

    public AttackHydroPump(){
        name = "Hydro Pump";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 110;
        description = "The target is blasted by a huge volume of water launched under great pressure.";
        accuracy = 80;
        powerpoints = 5;
    }

}