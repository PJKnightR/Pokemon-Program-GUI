package attack;

import type.Type;
import type.TypeIce;

public class AttackHaze extends Attack{

    public AttackHaze(){
        name = "Haze";
        type = Type.getType(TypeIce.SPOT);
        physical = false;
        power = 0;
        description = "The user creates a haze that eliminates every stat change among all the Pokémon engaged in battle.";
        accuracy = 0;
        powerpoints = 30;
    }
}
