package item;

public class PotionHyper extends Potion{
    public static byte ID = 6;
    public PotionHyper(int num){
        super(num);
        setItemName("Hyper Potion");
        setValue(1000);
        setHealthRestore(200);
    }
}
