package attack;

import type.Type;
import type.TypeDark;

public class AttackCrunch extends Attack{

    public AttackCrunch(){
        name = "Crunch";
        type = Type.getType(TypeDark.SPOT);
        physical = true;
        power = 80;
        description = "The user crunches up the target with sharp fangs. This may also lower the target's Defense stat.";
        accuracy = 100;
        powerpoints = 15;
    }
}
