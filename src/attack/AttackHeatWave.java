package attack;

import type.Type;
import type.TypeFire;

public class AttackHeatWave extends Attack{

    public AttackHeatWave(){
        name = "Heat Wave";
        type = Type.getType(TypeFire.SPOT);
        physical = false;
        power = 90;
        description = "The user attacks by exhaling hot breath on the opposing Pokémon. This may also leave those Pokémon with a burn.";
        accuracy = 90;
        powerpoints = 10;
    }

}