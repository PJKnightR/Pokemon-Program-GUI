package attack;

import type.Type;
import type.TypeNormal;

public class AttackSpitUp extends Attack{

    public AttackSpitUp(){
        name = "Spit Up";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 1;
        description = "The power stored using the move Stockpile is released at once in an attack. The more power is stored, the greater the move's power.";
        accuracy = 100;
        powerpoints = 10;
    }
}
