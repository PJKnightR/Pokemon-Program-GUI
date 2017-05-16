package attack;

import type.Type;
import type.TypeNormal;

public class AttackDoubleTeam extends Attack{

    public AttackDoubleTeam(){
        name = "Double Team";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "By rapidly moving, the user makes illusory copies of itself to raise its evasiveness.";
        accuracy = 0;
        powerpoints = 15;
    }
}
