package game;

import pokemon.Pokemon;

import javax.swing.*;
import java.util.Scanner;

public class BattleB{
    private int currentID;
    private Pokemon wild;
    private Scanner scan;
    private int selectedMove, wildSelectedMove;
    private boolean battling, enemyLoss, canRun, isPoisonedPlayer, isPoisonedWild, isParylizedPlayer, isParylizedWild;


    private JLabel encounterMsg = new JLabel();
    private JLabel sendOut = new JLabel();
    public ActionHandler actionHandler;
    public JPanel contentPane = PokemonMain.contentPane;
    public JFrame frame = PokemonMain.frame;
    public JButton cont3 = new JButton("Continue");

    public BattleB(){
        isParylizedWild = false;
        isParylizedPlayer = false;
        isPoisonedWild = false;
        isPoisonedPlayer = false;
        battling = true;
        enemyLoss = false;
    }

    public void startBattle(Player user, Scanner s, Boolean r) {
        currentID = 0;
        this.wild = Pokemon.wildPokemon(user);
        this.scan = s;
        canRun = r;
        System.out.println("A wild " + wild.getName() + " has appeared!");
        while (user.party[currentID].getHealth() == 0 && !user.party[currentID].getName().equalsIgnoreCase("Empty")){
            currentID++;
        }
        doBattle(user);
    }

    public void doBattle(Player user){
        while (battling && !enemyLoss){
            if (isPoisonedPlayer){
                if (getChance() > 50){
                    isPoisonedPlayer = false;
                    System.out.println("You are no longer poisoned");
                } else {
                    user.setHealthLeft(user.getHealthLeft() - (int)((user.getHealth() * .1) + 1));
                    System.out.println("You took " + (int)((user.getHealth() * .1) + 1) + " damage from poison.");
                    battling = checkPlayerStatus(user);
                    if (!battling){
                        System.out.println("You were defeated by the " + wild.getName() + "!");
                        break;
                    }
                }
            }

            if (isPoisonedWild){
                if (getChance() > 50){
                    isPoisonedWild = false;
                    System.out.println("The " + wild.getName() + " is no longer poisoned");
                } else {
                    wild.setHealthLeft(wild.getHealthLeft() - (int)((wild.getHealth() * .1) + 1));
                    System.out.println("The " + wild.getName() + " took " + (int)((enemy.getHealth() * .1) + 1) + " damage from poison.");
                    battling = checkEnemyStatus();
                    if (!battling){
                        System.out.println("You defeated the " + wild.getName() + "!");
                        enemyLoss = true;
                        break;
                    }
                }
            }

            if (battling){
                if(isParylizedPlayer){
                    if (getChance() > 50){
                        isParylizedPlayer = false;
                        System.out.println("You are no longer petrified!");
                    }
                }

                if(isParylizedWild){
                    if (getChance() > 50){
                        isParylizedWild = false;
                        System.out.println("The " + wild.getName() + " is no longer paralized");
                    }
                }

                if (user.getSpeed() >= wild.getSpeed()){
                    if(isParylizedPlayer){
                        if(getChance() > 50){
                            System.out.println("You are paralyzed but managed to move");
                            enemyDamageStep(user);
                        } else {
                            System.out.println("You are paralyzed and cannot move!");
                        }
                    } else {
                        enemyDamageStep(user);
                    }
                    if(battling){
                        if(isParylizedWild){
                            if(getChance() > 50){
                                System.out.println("The enemy is paralyzed but managed to attack!");
                                playerDamageStep(user);
                            } else {
                                System.out.println("The enemy is paralyzed and cannot move");
                            }
                        } else {
                            playerDamageStep(user);
                        }
                    }
                } else if (user.getSpeed() < wild.getSpeed()){
                    if(isParylizedEnemy){
                        if(getChance() > 50){
                            System.out.println("The enemy is paralyzed but managed to attack!");
                            playerDamageStep(user);
                        } else {
                            System.out.println("The enemy is paralyzed and cannot move");
                        }
                    } else {
                        playerDamageStep(user);
                    }

                    if(battling){
                        if(isParylizedPlayer){
                            if(getChance() > 50){
                                System.out.println("You are paralyzed but managed to move");
                                enemyDamageStep(user);
                            } else {
                                System.out.println("You are paralyzed and cannot move!");
                            }
                        } else {
                            enemyDamageStep(user);
                        }
                    }
                }
            }
        }

        if(enemyLoss){
            battleEnd(user);
        }
    }

    private void playerDamageStep(Player PC){
        PC.setHealthLeft(PC.getHealthLeft() - enemyAttack(PC));
        battling = checkPlayerStatus(PC);
        if (!battling){
            System.out.println("You were defeated by the " + wild.getName() + "!");
        }
    }

    private void enemyDamageStep(Player PC){
        wild.setHealthLeft(wild.getHealthLeft() - playerAttack(PC));
        battling = checkEnemyStatus();
        if (!battling){
            System.out.println("The wild " + wild.getName() + " fainted!");
            enemyLoss = true;
        }
    }

    public void battleEnd(Player PC){
        double itemChance;

        itemChance = getChance();
        if (itemChance > 50){
            PC.getInventory().addRandomItem();
        }
        if (wild.getDifficulty().equalsIgnoreCase("easy")){
            PC.gainExp(50 + (int)getChance());
            PC.gainGold(100 + (int)getChance());
        } else if (enemy.getDifficulty().equalsIgnoreCase("moderate")){
            PC.gainExp(100 + (int)getChance());
            PC.gainGold(150 + (int)getChance());
        } else if (enemy.getDifficulty().equalsIgnoreCase("hard")){
            PC.gainExp(250 + (int)getChance());
            PC.gainGold(200 + (int)getChance());
        } else {
            PC.gainExp(100);
            PC.gainGold(100);
        }
        System.out.print("!\n");

        if(PC.checkLevelUp()){
            PC.levelUp();
        }
    }

    public void playerMove(Player user){
        boolean action = false;
        String move;

        displayHealth(user);
        System.out.println("What should " + user.party[currentID].getName() + " do?");
        System.out.println("1. Fight   2. Bag");
        System.out.println("3. Pokemon 4. Run");
        while (!action){
            move = scan.next();
            if (move.equals("1")){
                action = true;
                selectAttack(user);
            } else if (move.equals("2")){
                action = true;
                this.selectedMove = 0;
                user.getInventory().useItem(user,this);
            } else if(move.equals("3")){
                selectPokemon(user);
                System.out.println("What should " + user.party[currentID].getName() + " do?");
                System.out.println("1. Fight   2. Bag");
                System.out.println("3. Pokemon 4. Run");
            } else if (move.equals("4")){
                action = true;
                this.selectedMove = 0;
                double run = getChance();
                if (run > 50 && canRun){
                    System.out.println("You escaped from the " + wild.getName());
                    this.selectedMove = -1;
                } else {
                    if (!canRun){
                        System.out.println("You cannot run from this battle.");
                    } else {
                        System.out.println("The " + wild.getName() + " blocks your escape path!");
                    }
                }
            } else {
                System.out.println("Please enter a valid move");
            }
        }
    }

    private void selectAttack(Player PC){
        int attack, r;
        String a;
        boolean done = false;

        for(int i = 0; i < 4; i++){
            System.out.print(i + 1 + ". " + PC.att.get(i).getAttackName() + " (Mana Cost: " + PC.att.get(i).getManaCost() + ") ");
        }
        System.out.println("\nEnter -1 to go back");


        while (!done){
            r = 0;
            a = scan.next();
            try
            {
                Integer.parseInt(a);
            } catch (NumberFormatException ex) {
                r = 1;
                System.out.println("Please enter an appropriate move number!");
            }
            if (r == 0){
                attack = Integer.parseInt(a);
                if (attack == -1){
                    done = true;
                    playerMove(PC);
                } else if (attack < -2  || attack > PC.att.size() || attack == 0) {
                    System.out.println("Please enter an applicable number!");
                } else if (PC.getManaLeft() < PC.att.get(attack - 1).getManaCost()){
                    System.out.println("Not enough mana for this attack! Please enter an applicable number!");
                } else {
                    done = true;
                    selectedMove = attack;
                }
            }

        }

    }

    private void playerRun(Player user){
        int run;
        run = (int) getChance();
        if (run > 50){
            System.out.println("Got away safely");
            game.displayOptionsMenu();
        } else {
            System.out.println("Could not escape");
            wildAttack(user);
        }
    }

    private int playerAttack(Player user){
        if (selectedMove == 0){
            return 0;
        } else {
            int att = selectedMove - 1;
            double damage;

            //PC.setManaLeft(PC.getManaLeft() - PC.att.get(att).getManaCost());

            damage = playerDamageCalc(attack, user);
            damage = Math.round(damage);
            System.out.println("You attack using " + PC.att.get(att).getAttackName() + ". It did " + (int)damage + " damage.");

            if (PC.att.get(att).getPoisonChance() > 0){
                if (getChance() >= PC.att.get(att).getPoisonChance()){
                    isPoisonedWild = true;
                    System.out.println("The " + wild.getName() + " has been poisoned!");
                }
            }
            if (PC.att.get(att).getParalyzChance() > 0){
                if (getChance() >= PC.att.get(att).getParalyzChance()){
                    isParylizedWild = true;
                    System.out.println("The " + wild.getName() + " has been paralyzed!");
                }
            }

            return (int) damage;
        }
    }

    private int playerDamageCalc(int attack, Player user){
        int att = attack - 1, d = 0;
        double damage, multiplier;

        multiplier = getModifier();

        if (user.party[currentID].att[att].getAttackName().equalsIgnoreCase("---")) { //not working
            System.out.println("Invalid Move");
            playerAttack(user);
        }

        if (user.party[currentID].att[att].isPhysical()){
            damage = (2 * user.party[currentID].getLevel() + 10) / 250 * (user.party[currentID].getAttack() / wild.getDefense()) * (user.party[currentID].att[att].getPower() + 2) * multiplier;
            d = (int) damage;
        } else {
            damage = ((2 * user.party[currentID].getLevel() + 10) / 250) * (user.party[currentID].getSpecialAttack() / wild.getSpecialDefense()) * (user.party[currentID].att[att].getPower() + 2) * multiplier;
            d = (int) damage;
        }

        return d;
    }

    private void displayPlayerStats(Pokemon p){
        String i;

        System.out.print("Name: " + p.getName() + " Level: " + p.getLevel() + "\nHealth: " + p.getHealthLeft() + "/" + p.getHealth() + ")\nAttack: "
                + p.getAttack() + ")\nDefense: " + p.getDefense() + ")\nSpeed: " + p.getSpeed() + "\nMana: "
                + "\nExperience: " + p.getExp() + "/" + 100 * p.getLevel() + " Gold: " + p.getGold());

        System.out.println("\nEnter -1 to go back");
        i = scan.next();
        while (!i.equals("-1")){
            System.out.println("Please enter a valid number!");
            i = scan.next();
        }
        displayHealth(p);
    }

    private void displayHealth(Player user){
        System.out.println("LV: " + wild.getLevel() + " " + wild.getName());
        System.out.println("HP: " + wildremainingHealth + "/" + wild.getHealthPoints());
        System.out.println("LV: " + user.party[currentID].getLevel() + " " + user.party[currentID].getName());
        System.out.println("HP: " + user.party[currentID].getHealth() + "/" + user.party[currentID].getHealthPoints());
    }

    public void wildAttack(Player user){
        double a = Math.random() * 3, multiplier;
        int att = (int) a;
        att = checkWildAttack(att);

        System.out.println("The wild " + wild.getName() + " used " + wild.att[att]);
        double damage;
        multiplier = getModifier();

        if (wild.att[att].isPhysical()){
            damage = ((2 * wild.getLevel() + 10) / 250) * (wild.getAttack() / user.party[0].getDefense()) * (wild.att[att].getPower() + 2) * multiplier;
        } else {
            damage = ((2 * wild.getLevel() + 10) / 250) * (wild.getSpecialAttack() / user.party[0].getSpecialDefense()) * (wild.att[att].getPower() + 2) * multiplier;
        }
        damage = Math.round(damage);
        System.out.println("It did " + damage + " damage");

        if (enemy.att.get(att).getPoisonChance() > 0){
            if (getChance() >= enemy.att.get(att).getPoisonChance()){
                isPoisonedPlayer = true;
                System.out.println("You have been poisoned!");
            }
        }
        if (enemy.att.get(att).getParalyzChance() > 0){
            if (getChance() >= enemy.att.get(att).getParalyzChance()){
                isParylizedPlayer = true;
                System.out.println("You have been paralyzed!");
            }
        }

        user.party [currentID].setHealth(Math.round(user.party[currentID].getHealth() - damage));
        if (user.party[currentID].getHealth() < 0){
            user.party[currentID].setHealth(0);
        }
        displayHealth(user);
        if (user.party [currentID].getHealth() <= 0){//needs to account for whole team.
            playerLose(user);
        } else {
            playerPhase(user);
        }
    }

    private void enemyMove(){
        double enemyMove = 1 + Math.random() * (enemy.att.size() - 1);
        enemySelectedMove = (int)enemyMove;
    }

    public void playerLose(Player user){
        int c = 0;
        System.out.println(user.party[currentID].getName() + " has fainted, choose a Pokemon.");
        while (c < 6){
            if (user.party[c].getHealth() > 0){
                int a = 1;
                selectPokemon(user);
            }
            c++;
        }
        System.out.println("You have been defeated!");
        System.exit(0);
    }

    public void wildLose(Player user){
        double chance = getChance();
        System.out.println("The " + wild.getName() + " has fainted!");
        System.out.println("You gained 50 exp, 100 pokemon exp, and 100 pokedollars!"); //currently constant,change later to depend of the pokemon
        if (chance < 70){
            user.getInventory().addRandomItem();
        }
        user.gainExperience();
        user.gainPokedollars();
        user.gainEVs(currentID, wild.getAtkEVG(), wild.getDefEVG(), wild.getSpAtkEVG(), wild.getSpDefEVG(), wild.getSpdEVG(), wild.getHpEVG());
        user.gainExperiencePokemon(currentID);
        game.displayOptionsMenu();
    }

    private int checkWildAttack(int att){ //doesnt work
        double a;
        while (wild.att[att].getAttackName().equals("---")) {
            a = Math.random() * 3;
            att = (int) a;
        }

        return att;
    }

    public void selectPokemon(Player user){ //will need exceptions for sending out if fainted
        user.getPartyPokemon();
        System.out.println("Select a pokemon by entering its slot number. Enter -1 to go back.");
        int s = scan.nextInt();
        if (s == -1){ //needs fixed for when a pokemon faints
            playerPhase(user);
        }
        if (s > 6 || s == 0 || s <= -2){
            System.out.println("Please enter a valid slot!");
            selectPokemon(user);
        }
        if (user.party[s - 1].getName().equalsIgnoreCase("Empty")  || user.party[s - 1].getHealth() == 0){
            System.out.println("Please enter a valid slot!");
            selectPokemon(user);
            }
        optionPokemon(s,user);
    }

    public void optionPokemon(int s, Player user){
        System.out.println("What would you like to do with " + user.party[s - 1].getName() + " ?");
        System.out.println("1. Switch\n2.Summary\n3.Check Moves\n-1. Go Back");
        int c = scan.nextInt();
        switch (c){
            case 1:
                if (s == currentID + 1){
                    System.out.println("That Pokemon is already in battle!");
                    optionPokemon(s,user);
                } else {
                    System.out.println("That's enough " + user.party[currentID].getName() + "!");
                    currentID = s - 1;
                    System.out.println("Go " + user.party[currentID].getName() + "!");
                    wildAttack(user);
                }
                break;
            case 2:
                s = s - 1;
                System.out.println("Name: " + user.party[s].getName());
                System.out.println("Level: " + user.party[s].getLevel());
                System.out.println("Attack: " + user.party[s].getAttack());
                System.out.println("Defense: " + user.party[s].getDefense());
                System.out.println("Special Attack: " + user.party[s].getSpecialAttack());
                System.out.println("Special Defense: " + user.party[s].getSpecialDefense());
                System.out.println("Speed: " + user.party[s].getSpeed());
                //System.out.println("HP: " + remainingHealth[s] + "/" + party[0].getHealthPoints());
                //System.out.println("EXP: " + pokemonExp[s] + " / " + toLevelUpPokemon);
                System.out.println("Enter -1 to go back.");
                int k = scan.nextInt();
                while (k != -1){
                    System.out.println("Please enter -1 to go back!");
                    k = scan.nextInt();
                }
                s++;
                optionPokemon(s,user);
                break;
            case 3:
                displayAttack(s, user);
                break;
            case -1:
                selectPokemon(user);
                break;
        }
    }

    private void displayAttack(int s, Player user){
        System.out.println("Select a move you would like to view");
        System.out.println("1. " + user.party[currentID].att[0] + "  2. " + user.party[currentID].att[1] + "\n3. " + user.party[currentID].att[2] + "  4. " + user.party[currentID].att[3]);
        System.out.println("Enter -1 to go back");
        int attack = scan.nextInt();
        while (attack < 1 && attack > 4 && attack != -1) {
            System.out.print("Please enter an applicable number!");
            attack = scan.nextInt();
        }
        if (attack == -1){
            optionPokemon(s,user);
        } else {
            System.out.println(user.party[currentID].att[attack - 1] + "\n" + user.party[currentID].att[attack - 1].getDescription() + "\nPower: " + user.party[currentID].att[attack - 1].getPower() + "\nType: " + user.party[currentID].att[attack - 1].getType());
            if (user.party[currentID].att[attack - 1].isPhysical()){
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
            displayAttack(s,user,game);
        }
    }

    private boolean checkPlayerStatus(Player PC){
        return user..getHealthLeft() > 0;
    }

    private boolean checkWildStatus(){
        return wild.getHealthLeft() > 0;
    }

    private int getCriticalHitModifier(){
        double c = Math.random() * (10);
        int a = (int) Math.round(c);
        if (a == 10){
            a = 2;
            System.out.println("It was a Critical Hit!");
        } else {
            a = 1;
        }
        return a;
    }

    private double getChance(){
        double chance = 1 + Math.random() * (100 - 1);
        chance = Math.round(chance);

        return chance;
    }

    private double getModifier(){
        double c = getCriticalHitModifier(), r =getRandomMultiplier(), multiplier;
        multiplier = c * r;
        return multiplier;
    }

    //public double getEffectivityMultiplier(){
        //if (user.attType1[attack] = "Fire" && wild.getElementalType)
    //}

    //public double getStabMultiplier(){

    //}

    private double getRandomMultiplier(){
        double r = .85 + Math.random() * (1 - .85);
        return r;
    }
}