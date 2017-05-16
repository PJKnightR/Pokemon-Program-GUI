package attack;

import type.Type;
import type.TypeNormal;

public class AttackGrowth extends Attack{

    public AttackGrowth(){
        name = "Growth";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user's body grows all at once, raising the Attack and Sp. Atk stats. The opposing Pokémon are attacked with a spray of harsh acid. This may also lower their Sp. Def stat.";
        accuracy = 0;
        powerpoints = 20;
    }
}
