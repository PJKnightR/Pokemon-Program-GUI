package attack;

import type.Type;
import type.TypeWater;

public class AttackRainDance extends Attack{

    public AttackRainDance(){
        name = "Rain Dance";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 0;
        description = "The user summons a heavy rain that falls for five turns, powering up Water-type moves.  It lowers the power of Fire-type moves.";
        accuracy = 0;
        powerpoints = 5;
    }
}
