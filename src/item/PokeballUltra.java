package item;

public class PokeballUltra extends Pokeball{
    public static final byte ID = 3;
    public PokeballUltra(int num){
        super(num);
        setItemName("Ultraball");
        setValue(1500);
        setBallBonus(2);
    }
}