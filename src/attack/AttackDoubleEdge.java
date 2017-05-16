package attack;

import type.Type;
import type.TypeNormal;

public class AttackDoubleEdge extends Attack{

    public AttackDoubleEdge(){
        name = "Double Edge";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 120;
        description = "A reckless, life-risking tackle. This also damages the user quite a lot.";
        accuracy = 100;
        powerpoints = 15;
    }

}