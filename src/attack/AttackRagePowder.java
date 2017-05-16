package attack;

import type.Type;
import type.TypeBug;

public class AttackRagePowder extends Attack{

    public AttackRagePowder(){
        name = "Rage Powder";
        type = Type.getType(TypeBug.SPOT);
        physical = false;
        power = 0;
        description = "The user scatters a cloud of irritating powder to draw attention to itself. Opponents aim only at the user.";
        accuracy = 0;
        powerpoints = 20;
    }
}
