package attack;

import type.Type;
import type.TypeFire;

public class AttackFlameBurst extends Attack{

    public AttackFlameBurst(){
        name = "Flame Burst";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 70;
        description = "The user attacks the target with a bursting flame. The bursting flame damages Pokémon next to the target as well.";
        accuracy = 100;
        powerpoints = 15;
    }

}