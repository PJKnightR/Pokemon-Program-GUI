package attack;

import type.Type;
import type.TypePsychic;

public class AttackLightScreen extends Attack{

    public AttackLightScreen(){
        name = "Light Screen";
        type = Type.getType(TypePsychic.SPOT);
        physical = false;
        power = 0;
        description = "A wondrous wall of light is put up to reduce damage from special attacks for five turns";
        accuracy = 0;
        powerpoints = 30;
    }
}
