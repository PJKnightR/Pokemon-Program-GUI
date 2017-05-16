package attack;

import type.Type;
import type.TypeGround;

public class AttackSandAttack extends Attack{

    public AttackSandAttack(){
        name = "Sand Attack";
        type = Type.getType(TypeGround.SPOT);
        physical = false;
        power = 0;
        description = "Sand is hurled in the target's face, reducing the target's accuracy.";
        accuracy = 100;
        powerpoints = 15;
    }
}
