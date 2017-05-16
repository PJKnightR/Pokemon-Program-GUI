package attack;

import type.Type;
import type.TypeBug;

public class AttackSilverWind extends Attack{

    public AttackSilverWind(){
        name = "Silver Wind";
        type = Type.getType(TypeBug.SPOT);
        physical = false;
        power = 60;
        description = "The target is attacked with powdery scales blown by the wind. This may also raise all the user's stats.";
        accuracy = 100;
        powerpoints = 5;
    }

}