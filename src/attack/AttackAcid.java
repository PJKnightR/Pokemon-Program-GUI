package attack;

import type.Type;
import type.TypePoison;

public class AttackAcid extends Attack{

    public AttackAcid(){
        name = "Acid";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 40;
        description = "The opposing Pokémon are attacked with a spray of harsh acid. This may also lower their Sp. Def stat.";
        accuracy = 100;
        powerpoints = 30;
    }
}
