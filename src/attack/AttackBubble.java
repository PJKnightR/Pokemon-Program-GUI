package attack;

import type.Type;
import type.TypeWater;

public class AttackBubble extends Attack{

    public AttackBubble(){
        name = "Bubble";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 40;
        description = "A spray of countless bubbles is jetted at the opposing Pokemon.  This may also lower their Speed stat.";
        accuracy = 100;
        powerpoints = 30;
    }
}
