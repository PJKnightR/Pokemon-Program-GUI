package attack;

import type.Type;
import type.TypeIce;

public class AttackIceBeam extends Attack{

    public AttackIceBeam(){
        name = "Ice Beam";
        type = Type.getType(TypeIce.SPOT);
        physical = true;
        power = 90;
        description = "The target is struck with an icy-cold beam of energy. This may also leave the target frozen.";
        accuracy = 100;
        powerpoints = 10;
    }

}