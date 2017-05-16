package item;

public class PokeballNormal extends Pokeball{
    public static final byte ID = 1;
    public PokeballNormal(int num){
        super(num);
        setItemName("Pokeball");
        setValue(200);
        setBallBonus(1);
    }

}
