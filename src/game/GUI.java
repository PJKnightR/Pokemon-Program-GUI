package game;

import type.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        JPanel cp = new JPanel();
        JLabel welcomeMsg = new JLabel ("<html><center>Welcome to the world of Pokemon.<br>I am the Pokemon Professor Oak.<br>Before we begin can you tell us your name and what Pokemon you would like to start with?</center></html>"), error = new JLabel("error");
        JTextField name = new JTextField("Enter your name", 15);
        JCheckBox squirt = new JCheckBox("Squirtle"), bulb = new JCheckBox("Bulbasaur"), charm = new JCheckBox("Charmander"), pika = new JCheckBox("Pikachu");
        JButton submit = new JButton("Start your Adventure!");
        GridBagConstraints c = new GridBagConstraints();
        ButtonGroup bg = new ButtonGroup();


        cp.setLayout(new GridBagLayout());
        bg.add(squirt);
        bg.add(bulb);
        bg.add(pika);
        bg.add(charm);
        error.setVisible(false);

        submit.addActionListener((ActionEvent arg0) -> {
            int type = -1;
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
                menu(new Player(name.getText(), type, new Game()));
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


    private void menu(Player player){ //TODO: Make this menu
        JLabel option = new JLabel ("What would you like to do?");

        /*
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
        cont2.setActionCommand("Continue2"); */




      //




        frame.setContentPane(new JPanel());
        frame.setVisible(true);
    }
}
