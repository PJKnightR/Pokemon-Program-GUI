package item;

public class PotionNormal extends Potion{
    public static final byte ID = 4;
    public PotionNormal(int num){
        super(num);
        setItemName("Potion");
        setValue(100);
        setHealthRestore(20);
    }
}