package attack;

import type.Type;
import type.TypeGrass;

public class AttackVineWhip extends Attack{

    public AttackVineWhip(){
        name = "Vine Whip";
        type = Type.getType(TypeGrass.SPOT);
        physical = true;
        power = 45;
        description = "The target is struck with slender, whiplike vines to inflict damage.";
        accuracy = 100;
        powerpoints = 25;
    }

}