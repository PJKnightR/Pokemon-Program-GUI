package attack;

import type.Type;
import type.TypeNormal;

public class AttackWhirlwind extends Attack{

    public AttackWhirlwind(){
        name = "Whirlwind";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The target is blown away, and a different Pokémon is dragged out. In the wild, this ends a battle against a single Pokémon.";
        accuracy = 0;
        powerpoints = 20;
    }
}
