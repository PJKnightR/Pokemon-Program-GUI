package game;

import shop.Shop;
import shop.ShopMart;
import type.Type;

import javax.swing.*;
import java.util.Scanner;

public class Game {
    public String trainerName;
    public int typ;
    public JPanel contentPane = new JPanel();
    public JFrame frame = new JFrame();
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


    public void setTyp(int a){
        typ = a;
    }

    public void createUser(){
        trainerName = trainer.getText();
        Pokedex pokedex = new Pokedex();
        Player user = new Player(trainerName, typ, pokedex);
        actionHandler.getUser(user);
        actionHandler.getPokedex(pokedex);
    }

    public void displayOptionsMenu(){
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

    public void adventure(Player user, Pokedex pokedex){
        double c;
        c = Math.random() * 100;
        c = Math.round(c);
        if (c <= 75){
            new Battle().startBattle(user, this, pokedex);
        } else if (c >= 76 && c <= 100){
            getLocation(user, pokedex);
        }
    }

    public void getLocation(Player user, Pokedex pokedex){
        double l = 1 + Math.random() * (5 - 1);
        int j = (int) l;


        switch (j){
            case 1:
                location = new JLabel("You found a town!");
                user.getInventory().addRandomItem();
                break;
            case 2:
                location = new JLabel("You found a forest!");
                user.getInventory().addRandomItem();
                break;
            case 3:
                location = new JLabel("You found a cave!");
                user.getInventory().addRandomItem();
                break;
            case 4:
                location = new JLabel("You found a mart!");
                Shop shop = new ShopMart();
                shop.shop(user, pokedex, this);
                break;
            case 5:
                location = new JLabel("You found a Pokemon Center!\nYour party was fully healed");
                user.healAll();
                //System.out.println("Would you like to access the PC? Enter 1 for yes, 2 for no");
                //Scanner scan = new Scanner(System.in);
                //int pc = scan.nextInt();
                //while (pc == 1 || pc == 2){
                //if (pc == 1){
                //cp.addPokemon();
                ///} else {

                //}
                //}
                break;
            case 6:
                location = new JLabel("You found a lake!");
                user.getInventory().addRandomItem();
                break;
        }
        display(frame, contentPane);
        contentPane.add(location);
        contentPane.add(cont2);
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
}
