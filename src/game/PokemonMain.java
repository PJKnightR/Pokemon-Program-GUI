package game;

import javax.swing.*;
import java.util.Scanner;

public class PokemonMain {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(PokemonMain::startGUI);

       // Game game = new Game();
       // game.getUserInfo();

    }

    public static void startGUI(){
        JFrame.setDefaultLookAndFeelDecorated(false);
        GUI g = new GUI();
    }




}
