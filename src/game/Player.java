package game;

import pokemon.Pokemon;

import javax.swing.*;
import java.util.Scanner;

public class Player{
        private double expTrainer, toLevelUp, toLevelUpPokemon;
        private int pokedollars, level = 1, ID;
        public String name;
        Pokemon party [] = new Pokemon [6];
        Pokemon storage [] = new Pokemon[120];
        Inventory inventory = new Inventory();
        public Pokedex playerDex;
        public Scanner scan = new Scanner(System.in);
        public JButton back = new JButton("Back");

        public Inventory getInventory(){
            return inventory;
        }

        public Pokemon[] getParty(){
            return party;
        }

        public Player(String trainerName, int typ){
            back.setActionCommand("Back");

            name = trainerName;
            playerDex = new Pokedex();
            Pokemon beginner = Pokemon.beginnerPokemon(typ - 1);
            party [0] = beginner;
            playerDex.addPokemon(party[0].getPokeNum());
            party[0].setExperience(0);
            party[0].setHealthLeft((int)beginner.getHealth());
            storage [0] = beginner;
            party [1] = Pokemon.emptySlot();
            party [2] = Pokemon.emptySlot();
            party [3] = Pokemon.emptySlot();
            party [4] = Pokemon.emptySlot();
            party [5] = Pokemon.emptySlot();
            ID = 0;
            expToLevelUp();
            expToLevelUpPokemon(0);
        }

        public int getNewID(){
            ID++;
            return ID;
        }

        void getAllStats(Game game){
            JLabel allStats = new JLabel("Name: " + name + "\nTrainer Level: " + this.getTrainerLevel() + "\nTo next level: " + this.getExp() + "/" + this.getToLevelUp() + "\nPokedollars: $" + this.getPokedollars());
           // game.display(frame, contentPane);
           // contentPane.add(allStats);
           // contentPane.add(back);
        }

        public String getName(){
            return name;
        }

        void gainExperience(){
            expTrainer = expTrainer + 50;
            if (expTrainer >= toLevelUp){
                levelUpTrainer();
            }
        }

        void gainPokedollars(){
            pokedollars += 100;
        }

        private int levelUpTrainer(){
            level++;
            expTrainer = expTrainer - toLevelUp;
            expToLevelUp();
            System.out.println("Congratulations, you are now trainer level " + level);

            return level;
        }

        private void expToLevelUp(){ //calculates expMax needed to level up for trainer
            toLevelUp = level * 1000;
        }

        private double getExp(){
            return expTrainer;
        }

        public int getPokedollars(){
            return pokedollars;
        }

        public void spendPokedollars(int a){
            pokedollars = pokedollars - a;
        }

        private double getToLevelUp(){
            return toLevelUp;
        }

        public void gainEVs(int currentID, double atk, double def, double spAtk, double spDef, double spd, double hp){
            if (party[currentID].getTotalEV() < 512 && party[currentID].getAtkEV() < 252){
                party[currentID].setAtkEv(party[currentID].getAtkEV() + atk);
                party[currentID].setTotalEv(party[currentID].getTotalEV() + atk);
                if (party[currentID].getTotalEV() > 512){
                    atk = party[currentID].getTotalEV() - 512;
                    party[currentID].setTotalEv(512);
                    party[currentID].setAtkEv(party[currentID].getAtkEV() - atk);
                }
                if (party[currentID].getAtkEV() > 252){
                    atk = party[currentID].getAtkEV() - 252;
                    party[currentID].setAtkEv(252);
                    party[currentID].setTotalEv(party[currentID].getTotalEV() - atk);
                }
            }
            if (party[currentID].getTotalEV() < 512 && party[currentID].getDefEV() < 252){
                party[currentID].setDefEv(party[currentID].getDefEV() + def);
                party[currentID].setTotalEv(party[currentID].getTotalEV() + def);
                if (party[currentID].getTotalEV() > 512){
                    def = party[currentID].getTotalEV() - 512;
                    party[currentID].setTotalEv(512);
                    party[currentID].setDefEv(party[currentID].getDefEV() - def);
                }
                if (party[currentID].getDefEV() > 252){
                    def = party[currentID].getDefEV() - 252;
                    party[currentID].setDefEv(252);
                    party[currentID].setTotalEv(party[currentID].getTotalEV() - def);
                }
            }
            if (party[currentID].getTotalEV() < 512 && party[currentID].getSpAtkEV() < 252){
                party[currentID].setSpAtkEv(party[currentID].getSpAtkEV() + spAtk);
                party[currentID].setTotalEv(party[currentID].getTotalEV() + spAtk);
                if (party[currentID].getTotalEV() > 512){
                    spAtk = party[currentID].getTotalEV() - 512;
                    party[currentID].setTotalEv(512);
                    party[currentID].setSpAtkEv(party[currentID].getSpAtkEV() - spAtk);
                }
                if (party[currentID].getSpAtkEV() > 252){
                    spAtk = party[currentID].getSpAtkEV() - 252;
                    party[currentID].setSpAtkEv(252);
                    party[currentID].setTotalEv(party[currentID].getTotalEV() - spAtk);
                }
            }
            if (party[currentID].getTotalEV() < 512 && party[currentID].getSpDefEV() < 252){
                party[currentID].setSpDefEv(party[currentID].getSpDefEV() + spDef);
                party[currentID].setTotalEv(party[currentID].getTotalEV() + spDef);
                if (party[currentID].getTotalEV() > 512){
                    spDef = party[currentID].getTotalEV() - 512;
                    party[currentID].setTotalEv(512);
                    party[currentID].setSpDefEv(party[currentID].getSpDefEV() - spDef);
                }
                if (party[currentID].getSpDefEV() > 252){
                    spDef = party[currentID].getSpDefEV() - 252;
                    party[currentID].setSpDefEv(252);
                    party[currentID].setTotalEv(party[currentID].getTotalEV() - spDef);
                }
            }
            if (party[currentID].getTotalEV() < 512 && party[currentID].getSpdEV() < 252){
                party[currentID].setSpdEv(party[currentID].getSpdEV() + spd);
                party[currentID].setTotalEv(party[currentID].getTotalEV() + spd);
                if (party[currentID].getTotalEV() > 512){
                    spd = party[currentID].getTotalEV() - 512;
                    party[currentID].setTotalEv(512);
                    party[currentID].setSpdEv(party[currentID].getSpdEV() - spd);
                }
                if (party[currentID].getSpdEV() > 252){
                    spd = party[currentID].getSpdEV() - 252;
                    party[currentID].setSpdEv(252);
                    party[currentID].setTotalEv(party[currentID].getTotalEV() - spd);
                }
            }
            if (party[currentID].getTotalEV() < 512 && party[currentID].getHpEV() < 252){
                party[currentID].setHpEv(party[currentID].getHpEV() + hp);
                party[currentID].setTotalEv(party[currentID].getTotalEV() + hp);
                if (party[currentID].getTotalEV() > 512){
                    hp = party[currentID].getTotalEV() - 512;
                    party[currentID].setTotalEv(512);
                    party[currentID].setHpEv(party[currentID].getHpEV() - hp);
                }
                if (party[currentID].getHpEV() > 252){
                    hp = party[currentID].getHpEV() - 252;
                    party[currentID].setHpEv(252);
                    party[currentID].setTotalEv(party[currentID].getTotalEV() - hp);
                }
            }

        }

        public void gainExperiencePokemon(int currentID){ //needs actual expMax calculations, needs changed in the event of multiple level ups at once, wont happen now cause set exp
            if (party[currentID].getLevel() < 100){
                party[currentID].setExperience(party[currentID].getExperience() + 100);
                if (party[currentID].getExperience() >= toLevelUpPokemon){
                    party[currentID].setLevel(party[currentID].getLevel() + 1);
                    party[currentID].setAttack(((party[currentID].getBaseAtk() * 2 + party[currentID].getAtkIV() + party[currentID].getAtkEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getAtkBonus());
                    party[currentID].setDefense(((party[currentID].getBaseDef() * 2 + party[currentID].getDefIV() + party[currentID].getDefEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getDefBonus());
                    party[currentID].setSpecialAttack(((party[currentID].getBaseSpAtk() * 2 + party[currentID].getSpAtkIV() + party[currentID].getSpAtkEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getSpAtkBonus());
                    party[currentID].setSpecialDefense(((party[currentID].getBaseSpDef() * 2 + party[currentID].getSpDefIV() + party[currentID].getSpDefEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getSpDefBonus());
                    party[currentID].setSpeed(((party[currentID].getBaseSpd() * 2 + party[currentID].getSpdIV() + party[currentID].getSpdEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getSpdBonus());
                    party[currentID].setHealth((int)((party[currentID].getBaseHp() * 2 + party[currentID].getHpIV() + party[currentID].getHpEV() / 4) * party[currentID].getLevel() / 100 + 5));
                    party[currentID].setHP(party[currentID].getHealth());
                    expToLevelUpPokemon(currentID);
                    System.out.println(party[currentID].getName() + " leveled up to level " + party[currentID].getLevel());
                    party[currentID].setExperience(0);
                    getNewMoves(currentID);
                }
                if (party[currentID].getLevEv() == party[currentID].getLevel()){
                    System.out.print("Congratulations, your " + party[0].getName());
                    Pokemon evolution = party[0].getEvolution();
                    party[currentID].setName(evolution.getName());
                    if (party[currentID].getName().equalsIgnoreCase("Raichu")){
                        party[currentID].setAttCount(0);
                        party[currentID].setCurrentAtt(0);
                    }
                    party[currentID].setPokeNum(evolution.getPokeNum());
                    this.playerDex.addPokemon(party[currentID].getPokeNum());
                    party[currentID].setEvolution(evolution.getEvolution());
                    party[currentID].setLevEv(evolution.getLevEv());
                    party[currentID].type = evolution.getElementType();
                    party[currentID].setBaseAtk(evolution.getBaseAtk());
                    party[currentID].setBaseDef(evolution.getBaseDef());
                    party[currentID].setBaseSpAtk(evolution.getBaseSpAtk());
                    party[currentID].setBaseSpDef(evolution.getBaseSpDef());
                    party[currentID].setBaseSpd(evolution.getBaseSpd());
                    party[currentID].setBaseHp(evolution.getBaseHp());
                    party[currentID].setLevel(party[currentID].getLevel() + 1);
                    party[currentID].setAttack(((party[currentID].getBaseAtk() * 2 + party[currentID].getAtkIV() + party[currentID].getAtkEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getAtkBonus());
                    party[currentID].setDefense(((party[currentID].getBaseDef() * 2 + party[currentID].getDefIV() + party[currentID].getDefEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getDefBonus());
                    party[currentID].setSpecialAttack(((party[currentID].getBaseSpAtk() * 2 + party[currentID].getSpAtkIV() + party[currentID].getSpAtkEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getSpAtkBonus());
                    party[currentID].setSpecialDefense(((party[currentID].getBaseSpDef() * 2 + party[currentID].getSpDefIV() + party[currentID].getSpDefEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getSpDefBonus());
                    party[currentID].setSpeed(((party[currentID].getBaseSpd() * 2 + party[currentID].getSpdIV() + party[currentID].getSpdEV() / 4) * party[currentID].getLevel() / 100 + 5) * party[currentID].nat.getSpdBonus());
                    party[currentID].setHealth((int)((party[currentID].getBaseHp() * 2 + party[currentID].getHpIV() + party[currentID].getHpEV() / 4) * party[currentID].getLevel() / 100 + 5));
                    party[currentID].setHP(party[currentID].getHealth());
                    party[currentID].attLevel = evolution.attLevel;
                    party[currentID].atts = evolution.atts;
                    System.out.println(" has evolved into a " + party[currentID].getName());
                    getNewMoves(currentID);
                }
            }
        }

        private void getNewMoves(int currentID){
            int levelCount;
            levelCount = party[currentID].attLevel[party[currentID].getCurrentAtt()];
            while (levelCount <= party[currentID].getLevel()){
                if (party[currentID].getAttCount() < 4){
                    System.out.println(party[currentID].getName() + " learned " + party[currentID].atts[party[currentID].getCurrentAtt()].getAttackName());
                    party[currentID].att[party[currentID].getAttCount()] = party[currentID].atts[party[currentID].getCurrentAtt()];
                    party[currentID].setCurrentAtt(party[currentID].getCurrentAtt() + 1);
                    party[currentID].setAttCount(party[currentID].getAttCount() + 1);
                    levelCount = party[currentID].attLevel[party[currentID].getCurrentAtt()];
                } else if (party[currentID].getAttCount() >= 4){
                    System.out.println(party[currentID].getName() + " would like to learn " + party[currentID].atts[party[currentID].getCurrentAtt()].getAttackName() + ". Select a move to replace with " + party[currentID].atts[party[currentID].getCurrentAtt()].getAttackName() + "\nEnter -1 to give up on learning the move.");
                    System.out.println("1. " + party[currentID].att[0] + "  2. " + party[currentID].att[1] + "\n3. " + party[currentID].att[2] + "  4. " + party[currentID].att[3]);
                    int choice = scan.nextInt();
                    while (choice < -1 || choice > 4 || choice == 0){
                        System.out.println("Please enter a valid move!");
                        choice = scan.nextInt();
                    }
                    if (choice == -1){
                        System.out.println(party[currentID].getName() + " did not learn " + party[currentID].atts[party[currentID].getCurrentAtt()].getAttackName());
                    } else {
                        System.out.println(party[currentID].getName() + " forgot " + party[currentID].att[choice].getAttackName() + " and learned " + party[currentID].atts[party[currentID].getCurrentAtt()].getAttackName());
                        party[currentID].att[choice - 1] =  party[currentID].atts[party[currentID].getCurrentAtt()];
                    }
                    party[currentID].setCurrentAtt(party[currentID].getCurrentAtt() + 1);
                    levelCount = party[currentID].attLevel[party[currentID].getCurrentAtt()];
                }
            }
        }

        private void expToLevelUpPokemon(int currentID){ //actual expMax calculation needed
            toLevelUpPokemon = Math.pow(party[currentID].getLevel() * 2 , 2);
        }

        void getPartyPokemon(){
            for (int i = 1; i <= 6; i++){
                System.out.println(i + ". " + party[i - 1].getName());
            }
        }


        void viewStats(){
            this.getPartyPokemon();
            System.out.println("Select a pokemon that you want to view. Enter -1 to go back.");
            int c = scan.nextInt();

            if (c != -1){
                int a = 0;
                while (a != 1 && c != -1) {
                    if (c > 6 || c == 0 || c <= -2){
                        System.out.println("Please enter a valid slot!");
                        c = scan.nextInt();
                    } else if (party[c - 1].getName().equalsIgnoreCase("Empty")){
                        System.out.println("That slot is empty. Please enter a valid slot!");
                        c = scan.nextInt();
                    } else {
                        a = 1;
                    }
                }
                if (c > -1){
                    System.out.println("What would you like to do with " + this.party[c - 1].getName() + " ?");
                    System.out.println("1.Summary\n2.Check Moves\n-1. Go Back");
                    int b = scan.nextInt();
                    switch (b){
                        case 1:
                            c = c - 1;
                            System.out.println("Name: " + party[c].getName());
                            System.out.println("Level: " + party[c].getLevel());
                            System.out.println(party [c].getGenderB());
                            System.out.println("Nature: " + party[c].nat.getNatureName());
                            System.out.println("Attack: " + party[c].getAttack());
                            System.out.println("Defense: " + party[c].getDefense());
                            System.out.println("Special Attack: " + party[c].getSpecialAttack());
                            System.out.println("Special Defense: " + party[c].getSpecialDefense());
                            System.out.println("Speed: " + party[c].getSpeed());
                            System.out.println("HP: " + party[c].getHealth() + "/" + party[c].getHealth());
                            System.out.println("EXP: " + party[c].getExperience() + " / " + toLevelUpPokemon);
                            System.out.println("Enter -1 to go back.");
                            int k = scan.nextInt();
                            while (k != -1){
                                System.out.println("Please enter -1 to go back!");
                                k = scan.nextInt();
                            }
                            viewStats();
                            break;
                        case 2:
                            c = c - 1;
                            displayAttackB(c);
                            break;
                        case -1:
                            this.getPartyPokemon();
                            viewStats();
                            break;
                    }
                }
            }
        }

        public void displayAttackB(int c){
            System.out.println("Select a move you would like to view");
            System.out.println(c);
            System.out.println("1. " + this.party[c].att[0] + "  2. " + this.party[c].att[1] + "\n3. " + this.party[c].att[2] + "  4. " + this.party[c].att[3]);
            System.out.println("Enter -1 to go back");
            int attack = scan.nextInt();
            while (attack < 1 && attack > 4 && attack != -1) {
                System.out.print("Please enter an applicable number!");
                attack = scan.nextInt();
            }
            if (attack == -1){
                viewStats();
            } else {
                System.out.println(this.party[c].att[attack - 1] + "\n" + this.party[c].att[attack - 1].getDescription() + "\nPower: " + this.party[c].att[attack - 1].getPower() + "\nType: " + this.party[c].att[attack - 1].getType());
                if (this.party[c].att[attack - 1].isPhysical()){
                    System.out.println("Physical");
                } else {
                    System.out.println("Special");
                }
                System.out.println("Enter -1 to go back");
                attack = scan.nextInt();
                while (attack != -1) {
                    System.out.print("Please enter an applicable number!");
                    attack = scan.nextInt();
                }
                displayAttackB(c);
            }
        }
/*
        //public double healthCheck(double healthGain){
        //if (party[0].getHealth() > party[0].getHealthPoints()){ //causing a crash
        //healthGain = party[0].getHealthPoints() - (party[0].getHealth() - healthGain);
        //party[0].setHealth(party[0].getHealthPoints());
        //}
        //return healthGain;
        //}
        */
        void healAll(){
            party[0].setHealthLeft((int)party[0].getHealth());
        }

        private int getTrainerLevel(){
            return(level);
        }/*
        public Pokemon getPokemon(){
            return(party[0]);
        }*/


}
