package attack;

import type.Type;
import type.TypeNormal;

/**
 * Created by coolp_000 on 3/15/2017.
 */
public class AttackLeer extends Attack{

    public AttackLeer(){
        name = "Leer";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user gives opposing Pokémon an intimidating leer that lowers the Defense stat.";
        accuracy = 100;
        powerpoints = 30;
    }
}
