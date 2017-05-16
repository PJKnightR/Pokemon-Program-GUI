package attack;

import type.Type;
import type.TypeFire;

public class AttackFireFang extends Attack{

    public AttackFireFang(){
        name = "Fire Fang";
        type = Type.getType(TypeFire.SPOT);
        physical = true;
        power = 65;
        description = "The user bites with flame-cloaked fangs. This may also make the target flinch or leave it with a burn.";
        accuracy = 95;
        powerpoints = 15;
    }

}