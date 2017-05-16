package attack;

import type.Type;
import type.TypeNormal;

public class AttackWrap extends Attack{

    public AttackWrap(){
        name = "Wrap";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 10;
        description = "A long body, vines, or the like are used to wrap and squeeze the target for four to five turns.";
        accuracy = 90;
        powerpoints = 20;
    }
}
