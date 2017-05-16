package attack;

import type.Type;
import type.TypeNormal;

public class AttackRapidSpin extends Attack{

    public AttackRapidSpin(){
        name = "Rapid Spin";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 20;
        description = "A spin attack that can also eliminate such moves as Bind, Wrap, Leech Seed, and Spikes.";
        accuracy = 100;
        powerpoints = 40;
    }
}
