package attack;

import type.Type;
import type.TypePsychic;

public class AttackPsybeam extends Attack{

    public AttackPsybeam(){
        name = "Psybeam";
        type = Type.getType(TypePsychic.SPOT);
        physical = false;
        power = 65;
        description = "The target is attacked with a peculiar ray. This may also leave the target confused.";
        accuracy = 100;
        powerpoints = 20;
    }

}