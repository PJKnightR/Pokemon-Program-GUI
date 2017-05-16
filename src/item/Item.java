package item;

import game.Player;

public abstract class Item {
    private String itemName;
    private int value;
    private boolean stackable;
    private int stack;

    public Item(int num){
        stack = num;
    }

    public static Item[] itemList(){
        return new Item[]{new ItemEmpty(1), new PokeballNormal(1), new PokeballGreat(1), new PokeballUltra(1), new PotionNormal(1), new PotionSuper(1), new PotionHyper(1)}; //TODO add the items here
    }

    public abstract int use(Player user);

    public String getItemName() {
        return itemName;
    }

    protected void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getValue() {
        return value;
    }

    protected void setValue(int value) {
        this.value = value;
    }

    public boolean isStackable() {
        return stackable;
    }

    protected void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }
}