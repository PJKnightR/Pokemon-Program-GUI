package attack;

import type.Type;
import type.TypePsychic;

public class AttackAgility extends Attack{

    public AttackAgility(){
        name = "Agility";
        type = Type.getType(TypePsychic.SPOT);
        physical = false;
        power = 0;
        description = "The user relaxes and lightens its body to move faster. This sharply raises the Speed stat.";
        accuracy = 0;
        powerpoints = 30;
    }
}
