package attack;

import type.Type;
import type.TypeGrass;

public class AttackPetalBlizzard extends Attack{

    public AttackPetalBlizzard(){
        name = "Petal Blizzard";
        type = Type.getType(TypeGrass.SPOT);
        physical = true;
        power = 90;
        description = "The user stirs up a violent petal blizzard and attacks everything around it.";
        accuracy = 100;
        powerpoints = 15;
    }

}