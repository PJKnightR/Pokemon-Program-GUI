package attack;

import type.Type;
import type.TypeNormal;

public class AttackGrowl extends Attack{

    public AttackGrowl(){
        name = "Growl";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 40;
        description = "The user growls in an endearing way, making opposing Pokémon less wary. This lowers their Attack stat.";
        accuracy = 100;
        powerpoints = 0;
    }
}
