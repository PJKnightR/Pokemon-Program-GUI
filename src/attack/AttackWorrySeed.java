package attack;

import type.Type;
import type.TypeGrass;

public class AttackWorrySeed extends Attack{

    public AttackWorrySeed(){
        name = "WorrySeed";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 0;
        description = "A seed that causes worry is planted on the target. It prevents sleep by making the target's Ability Insomnia.";
        accuracy = 100;
        powerpoints = 10;
    }
}
