package attack;

import type.Type;
import type.TypeNormal;

/**
 * Created by coolp_000 on 3/15/2017.
 */
public class AttackGlare extends Attack{

    public AttackGlare(){
        name = "Glare";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user intimidates the target with the pattern on its belly to cause paralysis.";
        accuracy = 100;
        powerpoints = 30;
    }
}
