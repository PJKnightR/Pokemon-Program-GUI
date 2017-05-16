package item;

public class PokeballGreat extends Pokeball{
    public static final byte ID = 2;
    public PokeballGreat(int num){
        super(num);
        setItemName("Greatball");
        setValue(500);
        setBallBonus(1.5);
    }

}