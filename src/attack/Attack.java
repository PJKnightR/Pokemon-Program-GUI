package attack;

import type.Type;

public abstract class Attack {
    protected String name, description;
    protected Type type;
    protected boolean physical, stat, target; //true for enemy, false for self
    protected int power, accuracy, powerpoints, poisonChance, paralyzChance, atkChange, defChange, spAtkChange, spDefChange,
            spdChange, recoil;

    public String getAttackName(){
        return name;
    }

    public Type getType(){
        return type;
    }

    public boolean isPhysical(){
        return physical;
    }

    public boolean isStat(){
        return stat;
    }

    public boolean getTarget(){
        return target;
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

    public int getPoisonChance(){
        return poisonChance;
    }

    public int getParalyzChance(){
        return paralyzChance;
    }

    public int getAtkChange(){
        return atkChange;
    }

    public int getDefChange() {
        return defChange;
    }

    public int getSpAtkChange() {
        return spAtkChange;
    }

    public int getSpDefChange() {
        return spDefChange;
    }

    public int getSpdChange() {
        return spdChange;
    }

    public int getRecoil() {
        return recoil;
    }
}
