package item;

public class PotionSuper extends Potion {
    public static final byte ID = 5;
    public PotionSuper(int num){
        super(num);
        setItemName("Super Potion");
        setValue(300);
        setHealthRestore(50);
    }
}
