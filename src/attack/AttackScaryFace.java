package attack;

import type.Type;
import type.TypeNormal;

public class AttackScaryFace extends Attack{

    public AttackScaryFace(){
        name = "Scary Face";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user frightens the target with a scary face to harshly lower its Speed stat.";
        accuracy = 100;
        powerpoints = 10;
    }
}
