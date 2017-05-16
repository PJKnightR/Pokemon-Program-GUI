package attack;

import type.Type;
import type.TypeDragon;

public class AttackDragonRage extends Attack{

    public AttackDragonRage(){
        name = "Dragon Rage";
        type = Type.getType(TypeDragon.SPOT);
        physical = false;
        power = 40;
        description = "This attack hits the target with a shock wave of pure rage. This attack always inflicts 40 HP damage.";
        accuracy = 100;
        powerpoints = 10;
    }

}