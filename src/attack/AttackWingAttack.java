package attack;

import type.Type;
import type.TypeFlying;

public class AttackWingAttack extends Attack {

    public AttackWingAttack() {
        name = "Wing Attack";
        type = Type.getType(TypeFlying.SPOT);
        physical = true;
        power = 60;
        description = "The target is struck with large, imposing wings spread wide to inflict damage.";
        accuracy = 100;
        powerpoints = 35;
    }
}