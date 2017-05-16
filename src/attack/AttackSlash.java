package attack;

import type.Type;
import type.TypeNormal;

public class AttackSlash extends Attack{

    public AttackSlash(){
        name = "Slash";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 70;
        description = "The target is attacked with a slash of claws or blades. Critical hits land more easily.";
        accuracy = 100;
        powerpoints = 20;
    }

}