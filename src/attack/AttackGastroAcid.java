package attack;

import type.Type;
import type.TypePoison;

public class AttackGastroAcid extends Attack{

    public AttackGastroAcid(){
        name = "Gastro Acid";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 0;
        description = "The user hurls up its stomach acids on the target. The fluid eliminates the effect of the target's Ability.";
        accuracy = 100;
        powerpoints = 10;
    }
}
