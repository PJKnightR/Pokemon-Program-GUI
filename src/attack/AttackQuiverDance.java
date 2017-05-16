package attack;

import type.Type;
import type.TypeBug;

public class AttackQuiverDance extends Attack{

    public AttackQuiverDance(){
        name = "Quiver Dance";
        type = Type.getType(TypeBug.SPOT);
        physical = false;
        power = 0;
        description = "The user lightly performs a beautiful, mystic dance. This boosts the user's Sp. Atk, Sp. Def, and Speed stats.";
        accuracy = 0;
        powerpoints = 20;
    }
}
