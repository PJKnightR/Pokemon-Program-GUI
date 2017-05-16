package game;

import java.util.Scanner;

public class Pokedex {
    public int currentPokemon = 26;
    public double [] caught = new double [currentPokemon];
    public String [] name =  new String [currentPokemon];
    public String [] description = new String [currentPokemon];
    public Pokedex(){
        name [0] = "Bulbasaur";
        description [0] = "Bulbasaur can be seen napping in bright sunlight.\nThere is a seed on its back.\nBy soaking up the sun's rays, the seed grows progressively larger.";
        name [1] = "Ivysaur";
        description [1] = "There is a bud on this Pokémon's back.\nTo support its weight, Ivysaur's legs and trunk grow thick and strong.\nIf it starts spending more time lying in the sunlight, it's a sign that the bud will bloom into a large flower soon.";
        name [2] = "Venusaur";
        description [2] = "There is a large flower on Venusaur's back.\nThe flower is said to take on vivid colors if it gets plenty of nutrition and sunlight.\nThe flower's aroma soothes the emotions of people.";
        name [3] = "Charmander";
        description [3] = "The flame the burns at the tip of its tail is an indication of its emotions.\nThe flame wavers when Charmander is enjoying itself.\nIf the Pokemon becomes enraged, the flame burns fiercely.";
        name [4] = "Charmeleon";
        description [4] = "Charmeleon mercilessly destroys its foes using its sharp claws.\nIf it encounters a strong foe, it turns aggressive.\nIn this excited state, the flame at the tip of its tail flares with a bluish white color.";
        name [5] = "Charizard";
        description [5] = "Charizard flies around the sky in search of powerful opponents.\nIt breathes fire of such great heat that it melts anything.\nHowever, it never turns its fiery breath on any opponent weaker than itself.";
        name [6] = "Squirtle";
        description [6] = "Squirtle's shell is not merely used for protection.\nThe shell's rounded shape and the grooves on its surface help minimize resistance in water, enabling this Pokémon to swim at high speeds.";
        name [7] = "Wartortle";
        description [7] = "Its tail is large and covered with a rich, thick fur.\nThe tail becomes increasingly deeper in color as Wartortle ages.\nThe scratches on its shell are evidence of this Pokémon's toughness as a battler.";
        name [8] = "Blastoise";
        description [8] = "Blastoise has water spouts that protrude from its shell.\nThe water spouts are very accurate.\nThey can shoot bullets of water with enough accuracy to strike empty cans from a distance of over 160 feet.";
        name [9] = "Caterpie";
        description [9] = "TEST";
        name [10] = "Metapod";
        description [10] = "TEST";
        name [11] = "Butterfree";
        description [11] = "TEST";
        name [12] = "Weedle";
        description [12] = "TEST";
        name [13] = "Kakuna";
        description [13] = "TEST";
        name [14] = "Beedrill";
        description [14] = "TEST";
        name [15] = "Pidgey";
        description [15] = "TEST";
        name [16] = "Pidgeotto";
        description [16] = "TEST";
        name [17] = "Pidgeot";
        description [17] = "TEST";
        name [18] = "Rattata";
        description [18] = "TEST";
        name [19] = "Raticate";
        description [19] = "TEST";
        name [20] = "Spearow";
        description [20] = "TEST";
        name [21] = "Fearow";
        description [21] = "TEST";
        name [22] = "Ekans";
        description [22] = "TEST";
        name [23] = "Arbok";
        description [23] = "TEST";
        name [24] = "Pikachu";
        description [24] = "TEST";
        name [25] = "Raichu";
        description [25] = "TEST";
    }

    public void addPokemon(int num){
        caught [num - 1] = 1;
    }

    public void displayPokedex(){
        Scanner scan = new Scanner(System.in);
        int num = 0;
        int remainder;
        while (num < currentPokemon){
            num++;
            System.out.print(num + ". ");
            num--;
            if (caught [num] == 1){
                System.out.print(name [num] + " ");
            } else {
                System.out.print("----- ");
            }
            num++;
            remainder = num % 15;
            if (remainder == 0){
                System.out.print("\n");
            }
        }

        System.out.println("\nSelect a Pokemon you want to view\nEnter -1 to go back.");
        num = scan.nextInt();
        while (num == 0 || num > currentPokemon || num <= -2){ //add exception for empty slots
            System.out.println("Please enter a valid number");
        }
        if (num != -1){
            System.out.println(description [num - 1]);
            System.out.println("Enter -1 to go back");
            num = scan.nextInt();
            while (num != -1){
                System.out.println("Please enter a valid number");
                num = scan.nextInt();
            }
            displayPokedex();
        }

    }
}
