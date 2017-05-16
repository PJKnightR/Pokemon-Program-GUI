package attack;

import type.Type;
import type.TypeWater;

public class AttackWaterPulse extends Attack{

    public AttackWaterPulse(){
        name = "Water Pulse";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 60;
        description = "The user attacks the target with a pulsing blast of water. This may also confuse the target.";
        accuracy = 100;
        powerpoints = 20;
    }

}