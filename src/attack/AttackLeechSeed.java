package attack;

import type.Type;
import type.TypeGrass;

public class AttackLeechSeed extends Attack{

    public AttackLeechSeed(){
        name = "Leech Seed";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 0;
        description = "A seed is planted on the target. It steals some HP from the target every turn.";
        accuracy = 90;
        powerpoints = 10;
    }
}
