package attack;

import type.Type;
import type.TypeBug;

public class AttackStringShot extends Attack{

    public AttackStringShot(){
        name = "StringShot";
        type = Type.getType(TypeBug.SPOT);
        physical = false;
        power = 0;
        description = "The opposing Pokémon are bound with silk blown from the user's mouth that harshly lowers the Speed stat.";
        accuracy = 95;
        powerpoints = 40;
    }
}
