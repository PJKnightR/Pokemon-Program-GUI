package attack;

import type.Type;
import type.TypeWater;

public class AttackWaterGun extends Attack{

    public AttackWaterGun(){
        name = "Water Gun";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 40;
        description = "The target is blasted with a forceful shot of water.";
        accuracy = 100;
        powerpoints = 25;
    }

}