package item;

import game.Player;

public abstract class Pokeball extends Item{
    private double ballBonus;

    public Pokeball(int num){
        super(num);
        setStackable(true);
    }
    public int use(Player user){
        setStack(getStack() - 1);
        return catchPokemon(ballBonus);
    }

    private int catchPokemon(double ballBonus){
        double rand = 1 + Math.random() * (50 - 1);
        double catched = rand * ballBonus;
        int caught;
        if (catched > 50){
            caught = 1;
        } else {
            caught = -1;
        }
        return caught;
    }

    protected void setBallBonus(double ballBonus) {
        this.ballBonus = ballBonus;
    }
}