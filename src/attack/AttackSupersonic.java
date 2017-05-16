package attack;

import type.Type;
import type.TypeNormal;

public class AttackSupersonic extends Attack{

    public AttackSupersonic(){
        name = "Supersonic";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user generates odd sound waves from its body that confuse the target.";
        accuracy = 55;
        powerpoints = 20;
    }
}
