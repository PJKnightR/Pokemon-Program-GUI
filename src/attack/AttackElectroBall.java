package attack;

import type.Type;
import type.TypeElectric;

public class AttackElectroBall extends Attack{

    public AttackElectroBall(){
        name = "Electro Ball";
        type = Type.getType(TypeElectric.SPOT);
        physical = true;
        power = 1;
        description = "The user hurls an electric orb at the target. The faster the user is than the target, the greater the move's power.";
        accuracy = 100;
        powerpoints = 10;
    }
}
