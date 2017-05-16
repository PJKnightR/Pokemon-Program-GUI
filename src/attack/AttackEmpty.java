package attack;

import type.TypeEmpty;

public class AttackEmpty extends Attack{
    /*
    TODO: BE REMOVED ONCE NO LONGER NECESSARY
     */
    public AttackEmpty(){
        name = "---";
        type = new TypeEmpty();
        physical = false;
        power = 0;
    }
}
