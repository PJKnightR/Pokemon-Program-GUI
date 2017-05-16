package attack;

import type.Type;
import type.TypeFighting;

public class AttackMirrorMove extends Attack{

    public AttackMirrorMove(){
        name = "Mirror Move";
        type = Type.getType(TypeFighting.SPOT);
        physical = false;
        power = 0;
        description = "The user counters the target by mimicking the target's last move.";
        accuracy = 0;
        powerpoints = 20;
    }
}
