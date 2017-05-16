package attack;

import type.Type;
import type.TypeNormal;

public class AttackSkullBash extends Attack{

    public AttackSkullBash(){
        name = "Skull Bash";
        type = Type.getType(TypeNormal.SPOT);
        physical = true;
        power = 130;
        description = "The user tucks in its head to raise its Defense stat on the first turn, then rams the target on the next turn.";
        accuracy = 100;
        powerpoints = 10;
    }

}