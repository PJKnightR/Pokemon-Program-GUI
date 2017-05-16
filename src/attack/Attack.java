package attack;

import type.Type;

public abstract class Attack {
    protected String name, description;
    protected Type type;
    protected boolean physical;
    protected int power, accuracy, powerpoints;

    public String getAttackName(){
        return name;
    }

    public Type getType(){
        return type;
    }

    public boolean isPhysical(){
        return physical;
    }

    public int getPower(){
        return power;
    }

    public String toString(){
        return(name);
    }

    public String getDescription(){
        return description;
    }

    public int getAccuracy(){
        return accuracy;
    }

    public int getPowerPoints(){
        return powerpoints;
    }
}
