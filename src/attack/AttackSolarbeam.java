package attack;

import type.Type;
import type.TypeGrass;

public class AttackSolarbeam extends Attack{

    public AttackSolarbeam(){
        name = "Solarbeam";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 120;
        description = "In this two-turn attack, the user gathers light, then blasts a bundled beam on the next turn.";
        accuracy = 100;
        powerpoints = 10;
    }

}