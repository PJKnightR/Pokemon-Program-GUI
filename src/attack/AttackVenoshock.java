package attack;

import type.Type;
import type.TypePoison;

public class AttackVenoshock extends Attack{

    public AttackVenoshock(){
        name = "Venoshock";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 65;
        description = "The user drenches the target in a special poisonous liquid. This move's power is doubled if the target is poisoned.";
        accuracy = 100;
        powerpoints = 10;
    }
}
