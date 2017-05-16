package attack;

import type.Type;
import type.TypeFlying;

public class AttackDrillPeck extends Attack{

    public AttackDrillPeck(){
        name = "Drill Peck";
        type = Type.getType(TypeFlying.SPOT);
        physical = true;
        power = 80;
        description = "A corkscrewing attack with a sharp beak acting as a drill.";
        accuracy = 100;
        powerpoints = 20;
    }
}
