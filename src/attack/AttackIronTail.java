package attack;

import type.Type;
import type.TypeSteel;

public class AttackIronTail extends Attack{

    public AttackIronTail(){
        name = "Iron Tail";
        type = Type.getType(TypeSteel.SPOT);
        physical = true;
        power = 100;
        description = "The target is slammed with a steel-hard tail. This may also lower the target's Defense stat.";
        accuracy = 75;
        powerpoints = 15;
    }
}
