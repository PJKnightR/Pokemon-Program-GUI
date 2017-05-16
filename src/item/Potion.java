package item;

import game.Player;

public abstract class Potion extends Item{
    private double healthRestore;

    public Potion(int num){
        super(num);
        setStackable(true);
    }

    public int use(Player user){
        double h = user.getParty()[0].getHealth(), hM;
        user.getParty()[0].setHealth(user.getParty()[0].getHealth() + healthRestore);
        hM = user.getParty()[0].getHealth();
        System.out.println("You have regained " + (hM - h) + " HP.");
        setStack(getStack() - 1);
        return 0;
    }

    protected void setHealthRestore(double healthRestore){
        this.healthRestore = healthRestore;
    }

}