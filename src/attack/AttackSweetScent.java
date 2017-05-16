package attack;

import type.Type;
import type.TypeNormal;

public class AttackSweetScent extends Attack{

    public AttackSweetScent(){
        name = "Sweet Scent";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "A sweet scent that harshly lowers opposing Pokémon's evasiveness.";
        accuracy = 100;
        powerpoints = 20;
    }
}
