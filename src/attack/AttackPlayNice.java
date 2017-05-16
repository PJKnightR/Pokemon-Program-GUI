package attack;

import type.Type;
import type.TypeNormal;

public class AttackPlayNice extends Attack{

    public AttackPlayNice(){
        name = "Play Nice";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The user and the target become friends, and the target loses its will to fight. This lowers the target's Attack stat.";
        accuracy = 0;
        powerpoints = 20;
    }
}
