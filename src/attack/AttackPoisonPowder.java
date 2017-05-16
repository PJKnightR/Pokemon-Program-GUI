package attack;

import type.Type;
import type.TypePoison;

public class AttackPoisonPowder extends Attack{

    public AttackPoisonPowder(){
        name = "Poison Powder";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 0;
        description = "The user scatters a cloud of poisonous dust that poisons the target.";
        accuracy = 75;
        powerpoints = 35;
    }
}
