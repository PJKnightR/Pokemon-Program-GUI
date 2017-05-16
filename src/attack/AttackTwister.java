package attack;

import type.Type;
import type.TypeDragon;

public class AttackTwister extends Attack{

    public AttackTwister(){
        name = "Twister";
        type = Type.getType(TypeDragon.SPOT);
        physical = false;
        power = 40;
        description = "The user whips up a vicious tornado to tear at the opposing Pokémon. This may also make them flinch.";
        accuracy = 100;
        powerpoints = 20;
    }

}