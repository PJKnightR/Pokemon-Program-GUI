package attack;

import type.Type;
import type.TypeGrass;

public class AttackRazorLeaf extends Attack{

    public AttackRazorLeaf(){
        name = "Razorleaf";
        type = Type.getType(TypeGrass.SPOT);
        physical = true;
        power = 55;
        description = "Sharp-edged leaves are launched to slash at the opposing Pokémon. Critical hits land more easily.";
        accuracy = 95;
        powerpoints = 25;
    }

}