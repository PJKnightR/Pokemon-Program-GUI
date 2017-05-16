package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{

    private Game game;
    private Player user;
    private Pokedex pokedex;
    private Battle bat;

    void getGame(Game g){
        game = g;
    }

    void getUser(Player u){
        user = u;
    }

    void getPokedex(Pokedex p){
        pokedex = p;
    }

    void getBattle(Battle b) {
        bat = b;
    }

    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        if (eventName.equals("Continue")) {
            game.createUser();
            game.clearPanel();
            game.displayOptionsMenu();
        } else if (eventName.equals("Explore")){
            game.clearPanel();
            game.adventure(user, pokedex);
        } else if (eventName.equals("Party")){
            user.viewStats();
            game.clearPanel();
            game.displayOptionsMenu();
        } else if (eventName.equals("Trainer Info")){
            game.clearPanel();
            user.getAllStats(game);
        } else if (eventName.equals("Inventory")){
            //user.getInventory().listItemsOutside();
            game.clearPanel();
            game.displayOptionsMenu();
        } else if (eventName.equals("Pokedex")){
            pokedex.displayPokedex();
            game.clearPanel();
            game.displayOptionsMenu();
        } else if (eventName.equals("Save")){
            System.out.println("This feature is coming soon!");
            game.clearPanel();
            game.displayOptionsMenu();
        } else if (eventName.equals("Quit")){
            game.clearPanel();
            System.exit(0);
        } else if (eventName.equals("Bulbasuar")){
            game.setTyp(1);
        } else if (eventName.equals("Charmander")){
            game.setTyp(2);
        } else if (eventName.equals("Squirtle")){
            game.setTyp(3);
        } else if (eventName.equals("Back") || eventName.equals("Continue2")){
            game.clearPanel();
            game.displayOptionsMenu();
        } else if (eventName.equals("Continue3")){
            bat.battle(user, game, pokedex);
        }
    }
}
