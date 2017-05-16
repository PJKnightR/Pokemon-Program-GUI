package attack;

import type.Type;
import type.TypeGrass;

public class AttackSynthesis extends Attack{

    public AttackSynthesis(){
        name = "Synthesis";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 0;
        description = "The user restores its own HP. The amount of HP regained varies with the weather.";
        accuracy = 0;
        powerpoints = 5;
    }
}
