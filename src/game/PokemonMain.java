package game;

import javax.swing.*;
import java.util.Scanner;

public class PokemonMain {

    public static JFrame frame = new JFrame("Pokemon Program");
    public static JPanel contentPane = new JPanel();
    public Game game = new Game();

    private PokemonMain(){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(PokemonMain::startGUI);

        Game game = new Game();
        game.getUserInfo();

    }

    public static void startGUI(){
        JFrame.setDefaultLookAndFeelDecorated(false);
        PokemonMain g = new PokemonMain();
    }




}
