package attack;

import type.Type;
import type.TypeGround;

public class AttackMudBomb extends Attack{

    public AttackMudBomb(){
        name = "MudBomb";
        type = Type.getType(TypeGround.SPOT);
        physical = false;
        power = 65;
        description = "The user launches a hard-packed mud ball to attack. This may also lower the target's accuracy.";
        accuracy = 85;
        powerpoints = 10;
    }
}
