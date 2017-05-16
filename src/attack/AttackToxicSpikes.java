package attack;

import type.Type;
import type.TypePoison;

public class AttackToxicSpikes extends Attack{

    public AttackToxicSpikes(){
        name = "ToxicSpikes";
        type = Type.getType(TypePoison.SPOT);
        physical = false;
        power = 0;
        description = "The user lays a trap of poison spikes at the feet of the opposing team. The spikes will poison opposing Pokémon that switch into battle.";
        accuracy = 0;
        powerpoints = 20;
    }
}
