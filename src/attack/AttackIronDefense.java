package attack;

import type.Type;
import type.TypeSteel;

public class AttackIronDefense extends Attack{

    public AttackIronDefense(){
        name = "Iron Defense";
        type = Type.getType(TypeSteel.SPOT);
        physical = false;
        power = 0;
        description = "The user hardens its body's surface like Iron, sharply raising its Defense Stat.";
        accuracy = 0;
        powerpoints = 15;
    }
}
