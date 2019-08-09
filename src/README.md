    Bug List:
    -User can get through without choosing a beginner

    Version History Beta:

    Version 1.2.1 8/9/19
    -Added the old Battle & Game classes to the old package
    -Added a check in battle so that you cannot send out a fainted Pokemon
    -Added a new variable to Battle that keeps track of when a players Pokemon faints
    -Added a method that allows the user to switch to a new Pokemon when one faints (if they have any more)
    -Added temporary stat change variables in battle in preparation for their implementation in moves
    -Added a variable to keep track of if an attack only effects stats in Attack as well as a get method for it
    -Added variables for stat changing moves, recoil moves, and attack target to Attack and their get methods
    -Re-Added awards from defeating Wild Pokemon in battles
    -Fixed a bug not allowing you to take a turn when in battle

    Version 1.2 8/7/19 The Grand Return and Cleanup Update
    -Added a variable in player for their Pokedex
    -Added a loop to game class to reduce method calls
    -Added poisoned and paralyzed status effects
    -Restructured the methods in Battle & Game based on the RPG_Game
    -Removed all unnecessary Pokedex calls in Battle, Player, Game, Shop, and Inventory
    -Removed unnecessary game calls from battle
    -Changed method names in Pokemon for simplification
    -Created the old package for old code
    -Fixed a bug where Arbok's name was Ekans

    Version 1.1.1
    -Converted checking trainer card into GUI
    -Began converting Battle into GUI format
    -Fixed items breaking everything

    Version 1.1
    -Converted the Game class completely into GUI format
    -Enabled some classes that were disabled in the previous version
    -Began converting most major classes into GUI format

    Version 1.0 5/11/2017
    -Beginning of GUI version based off of Version 0.67.00 alpha of the text-based Pokemon Program
    -Added the main game class and renamed it "Pokemon Main"
    -Added the options class and renamed it "Game" (This class will be responsible for most of the GUI)
    -Added main contentPane and frame
    -Added inputs for the users name and desired beginner Pokemon
    -Added all other current classes
    -Added the action handler class for buttons
    -Added new options menu where desired choice is selected by button
    -Added option to quit in options menus
    -Added option to view the players stats
    -Converted PokemonMain into GUI format
    -Began to add option to explore, check party, check trainer info, check bag, and check pokedex in options menu
    -Began to convert Game into GUI format
    -Began to convert Player class into GUI format
    -Removed old System.out.prints and Scanner inputs
    -Disabled and Enabled Misc classes