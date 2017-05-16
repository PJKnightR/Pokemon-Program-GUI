package attack;

import type.Type;
import type.TypeWater;

public class AttackWithdraw extends Attack{

    public AttackWithdraw(){
        name = "Withdraw";
        type = Type.getType(TypeWater.SPOT);
        physical = false;
        power = 0;
        description = "The user withdraws its body into its hard shell, raising its Defense stat.";
        accuracy = 0;
        powerpoints = 40;
    }
}
