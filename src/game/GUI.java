package game;

import shop.ShopMart;
import type.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GUI {
    private JFrame frame = new JFrame("Pokemon Program");

    public Game game = new Game();

    public GUI(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.setVisible(true);

        initPlayer();
    }


    private void initPlayer(){
        JLabel welcomeMsg = new JLabel ("<html><center>Welcome to the world of Pokemon.<br>I am the Pokemon Professor Oak.<br>Before we begin can you tell us your name and what Pokemon you would like to start with?</center></html>"), error = new JLabel("error");
        JCheckBox squirt = new JCheckBox("Squirtle"), bulb = new JCheckBox("Bulbasaur"), charm = new JCheckBox("Charmander"), pika = new JCheckBox("Pikachu");
        var cp = new JPanel();
        var name = new JTextField("Enter your name", 15);
        var submit = new JButton("Start your Adventure!");
        var c = new GridBagConstraints();
        var bg = new ButtonGroup();

        cp.setLayout(new GridBagLayout());
        bg.add(squirt);
        bg.add(bulb);
        bg.add(pika);
        bg.add(charm);
        error.setVisible(false);

        submit.addActionListener((var arg0) -> {
            var type = -1;
            if(bg.getSelection() == null)
                error.setVisible(true);
            else if(squirt.isSelected())
                type = 3;
            else if(bulb.isSelected())
                type = 1;
            else if(pika.isSelected())
                type=4;
            else if(charm.isSelected())
                type=2;
            if(type!=-1) {
                Type.initializeTypes();
                menu(new Player(name.getText(), type));
            }
        });

        c.insets = new Insets(0,0,10,0);
        c.gridwidth=5;
        c.gridx=0;
        c.gridy=0;
        cp.add(welcomeMsg,c);
        c.gridy=1;
        cp.add(name,c);
        c.insets = new Insets(0,70,10,10);
        c.gridwidth=1;
        c.gridx=0;
        c.gridy=2;
        cp.add(squirt,c);
        c.gridx=1;
        c.insets = new Insets(0,0,10,10);
        cp.add(bulb,c);
        c.gridx=2;
        cp.add(pika,c);
        c.gridx=3;
        c.insets = new Insets(0,0,10,0);
        cp.add(charm,c);
        c.insets = new Insets(0,0,10,0);
        c.gridwidth=5;
        c.gridx=0;
        c.gridy=3;
        cp.add(submit,c);
        c.gridy=4;
        cp.add(error,c);
        frame.add(cp);
    }

    private void explore(){
        var rand = new Random().nextInt(100);

        if(rand <= 75){
            //Battle
        } else {
            event();
        }
    }

    private void event(){
        var rand = new Random().nextInt(6);

        switch (rand){
            case 1 -> {}
                /*
                location = new JLabel("You found a mart!");
                Shop shop = new ShopMart();
                shop.shop(user, this);
                break; */
            case 2 -> {}
                /*
                System.out.println("You found a forest!");
                user.getInventory().addRandomItem();
                break; */
            case 3 -> {}
                /*
                System.out.println("You found a cave!");
                user.getInventory().addRandomItem();
                break; */
            case 4 -> {}
                /*
                System.out.println("You found a river!");
                user.getInventory().addRandomItem();
                break; */
            case 5 -> {}
                /*
                location = new JLabel("You found a Pokemon Center!\nYour party was fully healed");
                // user.healAll();
                break; */
            case 6 -> {}
                /*
                System.out.println("You found a lake!");
                user.getInventory().addRandomItem();
                break; */
        }
    }



    private void menu(Player player){
        JButton explore = new JButton("Explore"), party = new JButton("Party"), info = new JButton("Trainer Info"), bag = new JButton("Inventory"), dex = new JButton("Pokedex"),
                save = new JButton("Save"), quit = new JButton("Quit");
        var cp = new JPanel();
        var option = new JLabel ("What would you like to do, " + player.getName() + "?");
        var c = new GridBagConstraints();

        cp.setLayout(new GridBagLayout());
        explore.addActionListener((var arg0) -> {
            explore();

            //TODO: Eventually, we need to return to this menu, this means that, by design, all GUI actions are in this class and all logic actions are handled elsewhere
            menu(player);
        });
        quit.addActionListener((var arg0) -> System.exit(0));

        c.insets=new Insets(5,10,5,10);
        c.gridwidth=2;
        cp.add(option,c);
        c.gridwidth=1;
        c.gridy=1;
        cp.add(explore,c);
        c.gridy=2;
        cp.add(party,c);
        c.gridy=3;
        cp.add(info,c);
        c.gridy=1;
        c.gridx=1;
        cp.add(bag,c);
        c.gridy=2;
        cp.add(dex,c);
        c.gridy=3;
        cp.add(save,c);
        c.gridwidth=2;
        c.gridx=0;
        c.gridy=4;
        cp.add(quit,c);
        frame.setContentPane(cp);
        frame.setVisible(true);
    }
}
