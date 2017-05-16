package attack;

import type.Type;
import type.TypeGrass;

public class AttackPetalDance extends Attack{

    public AttackPetalDance(){
        name = "Petal Dance";
        type = Type.getType(TypeGrass.SPOT);
        physical = false;
        power = 120;
        description = "The user attacks the target by scattering petals for two to three turns. The user then becomes confused.";
        accuracy = 100;
        powerpoints = 10;
    }

}