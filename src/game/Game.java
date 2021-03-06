package game;

import shop.Shop;
import shop.ShopMart;
import type.Type;

import javax.swing.*;
import java.util.Scanner;

public class Game {
    public String trainerName;
    public int typ;
    private boolean running;
    private Scanner scan = new Scanner(System.in);
    private Player user;
    private int battleChance;

    public JPanel contentPane = null;
    public JFrame frame = null;
    public ActionHandler actionHandler = new ActionHandler();
    private JTextField trainer = new JTextField("What is your name?");
    private JLabel option = new JLabel ("What would you like to do?");
    private JButton explore = new JButton("Go Exploring");
    private JButton party = new JButton("Party");
    private JButton info = new JButton("Trainer Card");
    private JButton bag = new JButton("Bag");
    private JButton dex = new JButton("Pokedex");
    private JButton save = new JButton("Save");
    private JButton quit = new JButton("Quit");
    private JLabel location = new JLabel();
    private JButton cont2 = new JButton("Continue");

    public Game(){
        /*
        actionHandler.getGame(this);
        explore.addActionListener(actionHandler);
        explore.setActionCommand("Explore");
        party.addActionListener(actionHandler);
        party.setActionCommand("Party");
        info.addActionListener(actionHandler);
        info.setActionCommand("Trainer Info");
        bag.addActionListener(actionHandler);
        bag.setActionCommand("Inventory");
        dex.addActionListener(actionHandler);
        dex.setActionCommand("Pokedex");
        save.addActionListener(actionHandler);
        save.setActionCommand("Save");
        quit.addActionListener(actionHandler);
        quit.setActionCommand("Quit");
        cont2.addActionListener(actionHandler);
        cont2.setActionCommand("Continue2");
        Type.initializeTypes();
        running = true;
        battleChance = 75; */
    }

    public void getUserInfo(){
        display(frame, contentPane);
        JLabel welcomeMsg = new JLabel ("Welcome to the world of Pokemon.  I am the Pokemon Professor Oak.  Before we begin can you tell us your name and what Pokemon you would like to start with?");
        JLabel beg = new JLabel("Choose your beginner by clicking the appropriate button below");
        JButton beginner1 = new JButton("Bulbasaur");
      //  beginner1.addActionListener(actionHandler);
        beginner1.setActionCommand("Bulbasaur");
        JButton beginner2 = new JButton("Charmander");
        //beginner2.addActionListener(actionHandler);
        beginner2.setActionCommand("Charmander");
        JButton beginner3 = new JButton("Squirtle");
      //  beginner3.addActionListener(actionHandler);
        beginner3.setActionCommand("Squirtle");
        JButton cont = new JButton("Continue");
        //cont.addActionListener(actionHandler);
        cont.setActionCommand("Continue");

        contentPane.add(welcomeMsg);
        contentPane.add(trainer);
        contentPane.add(beg);
        contentPane.add(beginner1);
        contentPane.add(beginner2);
        contentPane.add(beginner3);
        contentPane.add(cont);
    }

    public void setTyp(int a){
        typ = a;
    }

    public void createUser(){
        trainerName = trainer.getText();
        Pokedex pokedex = new Pokedex();
        //Player user = new Player(trainerName, typ, this);
        actionHandler.getUser(user);
        actionHandler.getPokedex(pokedex);
    }

    /*public void displayOptionsMenu(){
        display(frame, contentPane);
        contentPane.add(option);
        contentPane.add(explore);
        contentPane.add(party);
        contentPane.add(info);
        contentPane.add(bag);
        contentPane.add(dex);
        contentPane.add(save);
        contentPane.add(quit);
    }

    public void adventure(Player user){
        double c;
        c = Math.random() * 100;
        c = Math.round(c);
        if (c <= 75){
            new Battle().startBattle(user);
        } else if (c >= 76 && c <= 100){
            getLocation(user);
        }
    }*/

    public void runGame(){
        while(running){
            String choice;
            int c;

            while(running){
                choice = scan.next();
                while (!choice.equals("1") && !choice.equals("2")){
                    System.out.println("Please enter a valid option");
                    choice = scan.next();
                }
                c = Integer.parseInt(choice);
                if(c == 1){
                    int g = getChance();
                    if (g <= battleChance){
                        Battle batbat = new Battle();
                        batbat.startBattle(user, scan, true);
                    } else {
                        getEvent(user);
                    }
                    if (user.party[0].getHealthLeft() <= 0) { //needs to check all Pokemon in party
                        System.out.print("\n\n\t\tGAME\tOVER\n\n\n");
                        running = false;
                    }
                } else {
                    //playerMenu();
                }
                if (running){
                    System.out.println("Enter '1' to continue your adventure! Enter '2' to go to the menu.");
                }
            }
            scan.nextLine();
            runGame();
        }
    }

    private void getEvent(Player user){
        double l = 1 + Math.random() * (6 - 1);
        int j = (int) Math.round(l);

        switch (j){
            case 1:
                location = new JLabel("You found a mart!");
                Shop shop = new ShopMart();
                shop.shop(user, this);
                break;
            case 2:
                System.out.println("You found a forest!");
                user.getInventory().addRandomItem();
                break;
            case 3:
                System.out.println("You found a cave!");
                user.getInventory().addRandomItem();
                break;
            case 4:
                System.out.println("You found a river!");
                user.getInventory().addRandomItem();
                break;
            case 5:
                location = new JLabel("You found a Pokemon Center!\nYour party was fully healed");
               // user.healAll();
                break;
            case 6:
                System.out.println("You found a lake!");
                user.getInventory().addRandomItem();
                break;
        }
    }

    public static void display(JFrame frame, JPanel contentPane) {
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public void clearPanel (){
        contentPane.removeAll();
    }

    public ActionHandler getActionHandler(){
        return actionHandler;
    }

    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
        } catch (NumberFormatException ich){
            return false;
        }
        return true;
    }

    private int getChance(){
        double chance;
        int i;

        chance = Math.random() * 100;
        i = (int) Math.round(chance);

        return i;
    }
}
