package attack;

import type.Type;
import type.TypeGrass;

public class AttackSeedBomb extends Attack{

    public AttackSeedBomb(){
        name = "Seed Bomb";
        type = Type.getType(TypeGrass.SPOT);
        physical = true;
        power = 80;
        description = "The user slams a barrage of hard-shelled seeds down on the target from above.";
        accuracy = 100;
        powerpoints = 15;
    }

}