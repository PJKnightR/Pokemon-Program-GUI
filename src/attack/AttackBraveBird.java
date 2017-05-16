package attack;

import type.Type;
import type.TypeFlying;

public class AttackBraveBird extends Attack{

    public AttackBraveBird(){
        name = "Brave Bird";
        type = Type.getType(TypeFlying.SPOT);
        physical = true;
        power = 120;
        description = "The user tucks in its wings and charges from a low altitude. This also damages the user quite a lot.";
        accuracy = 100;
        powerpoints = 15;
    }

}