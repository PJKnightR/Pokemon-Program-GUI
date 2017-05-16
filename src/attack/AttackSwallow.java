package attack;

import type.Type;
import type.TypeNormal;

public class AttackSwallow extends Attack{

    public AttackSwallow(){
        name = "Swallow";
        type = Type.getType(TypeNormal.SPOT);
        physical = false;
        power = 0;
        description = "The power stored using the move Stockpile is absorbed by the user to heal its HP. Storing more power heals more HP.";
        accuracy = 0;
        powerpoints = 10;
    }
}
