package game;

import pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import item.Item;

public class Inventory {
    ArrayList<Item> itemList = new ArrayList<Item>();
    public Scanner scan = new Scanner(System.in);

    public Inventory() {
    }

    public void addRandomItem(){
        if (itemList.size() < 60) {
            Item item = Item.itemList()[idGenerator()];
            System.out.println("You found a " + item.getItemName());
            itemList.add(item);
        } else {
            System.out.println("Bag is full");
        }
        stackItem();
    }

    public void addNewItem(Item i, Pokedex pokedex){
        itemList.add(i);
        stackItem();
    }

    public void useItem(Player user, Battle bat, Pokemon wild, Game game, Pokedex pokedex){ //need methods during and not during battle
        int position = 0;
        int caught;
        if (itemList.size() == 0){
            System.out.println("No items in Inventory");
            position = -1;
        }
        while(position != -1){
            System.out.println("What item do you want to use?");
            listItems();
            System.out.println("Enter -1 to go back");
            position = scan.nextInt();
            switch(position){
                case -1:
                    bat.playerPhase(user, game, pokedex);
                    break;
                case -2:
                    System.out.println("Enter the item number, not the item name!");
                    break;
                default:
                    position--;
                    try{
                        caught = itemList.get(position).use(user); //something around here is broken
                    } catch (IndexOutOfBoundsException blarg){
                        System.out.println("No item in that slot");
                        break;
                    }
                    removeItems();
                    position = -1;
                    if (caught == 1){
                        System.out.println("The wild " + wild.getName() + " was caught!");
                        int id = user.getNewID();
                        int c = 0;
                        while (c < 5){
                            if (user.party[c].getName().equals("Empty")){
                                user.party[c] = wild;
                                c = 5;
                            }
                            c++;
                        }
                        user.party[id].setLevel(wild.getLevel());
                        user.party[id].setExperience(0);
                        user.storage[id] = wild;
                        user.party[id].setHealth(user.party[id].getHealthPoints());
                        pokedex.addPokemon(user.party[id].getPokeNum() + 1);
                        //PC.addPokemon(wild);
                        game.displayOptionsMenu();
                        break;
                    } else if (caught == -1) {
                        System.out.println(wild.getName() + " escaped the ball!");
                        bat.wildAttack(user, game, pokedex);
                    } else {
                        bat.wildAttack(user, game, pokedex);
                    }
            }
        }
        bat.wildAttack(user, game, pokedex);
    }

    public void listItemsOutside(){
        if (itemList.isEmpty()){
            System.out.println("The Bag is empty");
        } else {
            int num = 1;
            for(Item i : itemList){
                System.out.println(num + ". " + i.getItemName() + " (x" + i.getStack() + ")");
                num++;
            }
            //useItem(); items outside of battle need to be added
        }

    }

    public void listItems(){
        if (itemList.isEmpty()){
            System.out.println("The Bag is empty");
        }
        int num = 1;
        for(Item i : itemList){
            System.out.println(num + ". " + i.getItemName() + " (x" + i.getStack() + ")");
            num++;
        }
    }

    private void stackItem(){
        Item[] stacking = itemList.toArray(new Item[itemList.size()]);
        byte num = Byte.valueOf(Integer.toString(stacking.length - 1)), num1 = 0;
        if(stacking.length > 1) {
            for (Item i : stacking) {
                for (byte j = num; j > num1; j--) {
                    //System.out.println(i.getItemName() + " | " + stacking[j].getItemName() + " | " + j);
                    if (i.isStackable() && stacking[j].isStackable() && stacking[j].getStack() > 0 && i.getItemName().equals(stacking[j].getItemName())) {
                        i.setStack(i.getStack() + 1);
                        stacking[j].setStack(0);
                    }
                }
                num1++;
            }
            itemList.clear();
            itemList = new ArrayList<>(Arrays.asList(stacking));
            removeItems();
        }

    }

    private void removeItems(){
        for(byte i = 0; i < itemList.size(); i++){
            if(itemList.get(i).getStack() == 0)
                itemList.remove(i);
        }
    }

    private int idGenerator(){
        double a;
        int b;

        a = 1 + Math.random() * (6 - 1);
        b = (int) Math.round(a);

        return b;
    }
}
