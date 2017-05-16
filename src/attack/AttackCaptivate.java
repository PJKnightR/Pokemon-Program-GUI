package attack;

import type.Type;
import type.TypeNormal;

public class AttackCaptivate extends Attack{

    public AttackCaptivate(){
        name = "Captivate";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "If any opposing Pokémon is the opposite gender of the user, it is charmed, which harshly lowers its Sp. Atk stat.";
        accuracy = 100;
        powerpoints = 20;
    }
}
