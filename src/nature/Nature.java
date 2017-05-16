package nature;

public abstract class Nature {

    protected double atkBonus, defBonus, spAtkBonus, spDefBonus, spdBonus;
    protected String natureName;

    public String getNatureName(){
        return natureName;
    }

    public double getAtkBonus(){
        return atkBonus;
    }

    public double getDefBonus(){
        return defBonus;
    }

    public double getSpAtkBonus(){
        return spAtkBonus;
    }

    public double getSpDefBonus(){
        return spDefBonus;
    }

    public double getSpdBonus(){
        return spdBonus;
    }
}
