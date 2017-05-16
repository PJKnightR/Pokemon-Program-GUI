package attack;

import type.Type;
import type.TypeNormal;

/**
 * Created by coolp_000 on 3/15/2017.
 */
public class AttackScreech extends Attack{

    public AttackScreech(){
        name = "Screech";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "An earsplitting screech harshly lowers the target's Defense stat.";
        accuracy = 85;
        powerpoints = 40;
    }
}
