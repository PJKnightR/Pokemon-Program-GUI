package attack;

import type.Type;
import type.TypeNormal;

/**
 * Created by coolp_000 on 3/16/2017.
 */
public class AttackStockpile extends Attack{

    public AttackStockpile(){
        name = "Stockpile";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user charges up power and raises both its Defense and Sp. Def stats. The move can be used three times.";
        accuracy = 0;
        powerpoints = 20;
    }
}
