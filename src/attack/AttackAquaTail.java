package attack;

import type.Type;
import type.TypeWater;

public class AttackAquaTail extends Attack{

    public AttackAquaTail(){
        name = "Aqua Tail";
        type = Type.getType(TypeWater.SPOT);
        physical = true;
        power = 90;
        description = "The user attacks by swinging its tail as if it were a vicious wave in a raging storm.";
        accuracy = 90;
        powerpoints = 10;
    }

}