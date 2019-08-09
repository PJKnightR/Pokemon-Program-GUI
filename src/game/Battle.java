package game;

import pokemon.Pokemon;

import java.util.Scanner;

public class Battle {
    private int currentID;
    private Pokemon enemy;
    private Scanner scan;
    private int selectedMove, enemySelectedMove, playerAtkChange, playerDefChange, playerSpAtkChange, playerSpDefChange,
            playerSpdChange, enemyAtkChange, enemyDefChange, enemySpAtkChange, enemySpDefChange, enemySpdChange ;
    private boolean battling, playerFaint, enemyFaint, canRun, isPoisonedPlayer, isPoisonedEnemy, isParylizedPlayer,
            isParylizedEnemy, wildBattle, trainerBattle;
    //add variables for the moves that raise and lower stats. Will be 0 by default

    public Battle(){
        isParylizedEnemy = false;
        isParylizedPlayer = false;
        isPoisonedEnemy = false;
        isPoisonedPlayer = false;
        battling = true;
        enemyFaint = false;
        playerFaint = false;
        playerAtkChange = 0;
        playerDefChange = 0;
        playerSpAtkChange = 0;
        playerSpDefChange = 0;
        playerSpdChange = 0;
        enemyAtkChange = 0;
        enemyDefChange = 0;
        enemySpAtkChange = 0;
        enemySpDefChange = 0;
        enemySpdChange = 0;
    }

    public void startBattle(Player user, Scanner s, Boolean r){
        currentID = 0;
        this.enemy = Pokemon.wildPokemon(user);
        this.scan = s;
        canRun = r;
        System.out.println("A wild " + enemy.getName() + " has appeared! Go " + user.party[currentID].getName() + "!Game");
        while (user.party[currentID].getHealth() == 0 && !user.party[currentID].getName().equalsIgnoreCase("Empty")){
            currentID++;
        }
        doBattle(user);
    }

    public void doBattle(Player user){
        while (battling && !enemyFaint && !playerFaint){
            if (isPoisonedPlayer){
                if (getChance() > 50){
                    isPoisonedPlayer = false;
                    System.out.println("You are no longer poisoned");
                } else {
                    user.party[currentID].setHealthLeft((int)user.party[currentID].getHealthLeft() - (int)((user.party[currentID].getHealth() * .1) + 1));
                    System.out.println("You took " + (int)((user.party[currentID].getHealth() * .1) + 1) + " damage from poison.");
                    battling = checkPlayerStatus(user);
                    if (!battling){
                        System.out.println("You were defeated by the " + enemy.getName() + "!");
                        playerFaint = true;
                        break;
                    }
                }
            }

            if (isPoisonedEnemy){
                if (getChance() > 50){
                    isPoisonedEnemy = false;
                    System.out.println("The " + enemy.getName() + " is no longer poisoned");
                } else {
                    enemy.setHealthLeft((int)enemy.getHealthLeft() - (int)((enemy.getHealth() * .1) + 1));
                    System.out.println("The " + enemy.getName() + " took " + (int)((enemy.getHealth() * .1) + 1) + " damage from poison.");
                    battling = checkEnemyStatus();
                    if (!battling){
                        System.out.println("You defeated the " + enemy.getName() + "!");
                        enemyFaint = true;
                        break;
                    }
                }
            }

            if (battling){

                playerMove(user);
                if (selectedMove == -1){
                    break;
                }
                enemyMove();

                if(isParylizedPlayer){
                    if (getChance() > 50){
                        isParylizedPlayer = false;
                        System.out.println("You are no longer paralyzed!");
                    }
                }

                if(isParylizedEnemy){
                    if (getChance() > 50){
                        isParylizedEnemy = false;
                        System.out.println("The " + enemy.getName() + " is no longer paralyzed");
                    }
                }

                if (user.party[currentID].getSpeed() + playerSpdChange >= enemy.getSpeed() + enemySpdChange){
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
                    }
                } else if (user.party[currentID].getSpeed() + playerSpdChange < enemy.getSpeed() + enemySpdChange){
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

        if(playerFaint){
            playerFaint(user);
        } else if(enemyFaint){
            enemyFaint(user);
        }
    }

    private void playerDamageStep(Player user){
        user.party[currentID].setHealthLeft((int)user.party[currentID].getHealthLeft() - enemyAttack(user));
        battling = checkPlayerStatus(user);
        if (!battling){
            System.out.println(user.party[currentID].getName() + " fainted!");
            playerFaint = true;
        }
    }

    private void enemyDamageStep(Player user){
        enemy.setHealthLeft((int)enemy.getHealthLeft() - playerAttack(user));
        battling = checkEnemyStatus();
        if (!battling){
            System.out.println("The " + enemy.getName() + " fainted!");
            enemyFaint = true;
        }
    }

    public void playerFaint(Player user){
        if(user.party[0].getHealthLeft() != 0 || user.party[1].getHealthLeft() != 0 || user.party[2].getHealthLeft() != 0 ||
                user.party[3].getHealthLeft() != 0 || user.party[4].getHealthLeft() != 0 || user.party[5].getHealthLeft() != 0){
            selectPokemon(user);
            doBattle(user);
        }
    }

    public void enemyFaint(Player user){
        //a check for if there were multiple pokemon being fought. ie double or trainer battles
        double itemChance;

        itemChance = getChance();
        if (itemChance > 50){
            user.getInventory().addRandomItem();
        }
        System.out.println("You gained 50 exp, 100 pokemon exp, and 100 pokedollars!"); //currently constant,change later to depend of the pokemon
        user.gainExperience();
        user.gainPokedollars();
        user.gainEVs(currentID, enemy.getAtkEVG(), enemy.getDefEVG(), enemy.getSpAtkEVG(), enemy.getSpDefEVG(), enemy.getSpdEVG(), enemy.getHpEVG());
        user.gainExperiencePokemon(currentID);

    }

    public void playerMove(Player user){
        boolean action = false;
        String move;

        displayHealth(user);
        System.out.println("What would you like to do? (Enter the corresponding number):\n 1. Fight\n 2. Inventory\n 3. Pokemon\n 4. Run");
        while (!action){
            move = scan.next();
            if (move.equals("1")){
                action = true;
                selectAttack(user);
            } else if (move.equals("2")){
                action = true;
                this.selectedMove = 0;
                user.getInventory().useItem(user,this, enemy);
            } else if(move.equals("3")){
                action = selectPokemon(user);
                System.out.println("What would you like to do?\n 1. Fight\n 2. Inventory\n 3. Pokemon\n 4. Run");
            } else if (move.equals("4")){
                action = true;
                this.selectedMove = 0;
                double run = getChance();
                if (run > 50 && canRun){
                    System.out.println("You escaped from the " + enemy.getName());
                    this.selectedMove = -1;
                } else {
                    if (!canRun){
                        System.out.println("You cannot run from this battle.");
                    } else {
                        System.out.println("The " + enemy.getName() + " blocks your escape path!");
                    }
                }
            } else {
                System.out.println("Please enter a valid move");
            }
        }
    }

    public boolean selectPokemon(Player user){ //will need exceptions for sending out if fainted
        user.getPartyPokemon();
        System.out.println("Select a pokemon by entering its slot number. Enter -1 to go back.");
        int s = scan.nextInt();
        if (s == -1){ //needs fixed for when a pokemon faints
            return false;
        }
        if (s > 6 || s == 0 || s <= -2){
            System.out.println("Please enter a valid slot!");
            selectPokemon(user);
        }
        if (user.party[s - 1].getName().equalsIgnoreCase("Empty")  || user.party[s - 1].getHealth() == 0){
            System.out.println("Please enter a valid slot!");
            selectPokemon(user);
        }
        return optionPokemon(s,user);
    }

    public boolean optionPokemon(int s, Player user){
        System.out.println("What would you like to do with " + user.party[s - 1].getName() + " ?");
        System.out.println("1. Switch\n2.Summary\n3.Check Moves\n-1. Go Back");
        int c = scan.nextInt();
        switch (c){
            case 1:
                if (s == currentID + 1){
                    System.out.println("That Pokemon is already in battle!");
                    optionPokemon(s,user);
                } else if (user.party[s - 1].getHealthLeft() == 0){
                    System.out.println("This Pokemon is fainted and cannot battle!");
                } else {
                    System.out.println("That's enough " + user.party[currentID].getName() + "!");
                    currentID = s - 1;
                    System.out.println("Go " + user.party[currentID].getName() + "!");
                }
                return true;
            case 2:
                displayPlayerStats(user, s);
                optionPokemon(s,user);
                break;
            case 3:
                displayAttack(s, user);
                break;
            case -1:
                selectPokemon(user);
                return false;
        }
        return false;
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
            displayAttack(s,user);
        }
    }

    private void displayPlayerStats(Player user, int s){
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

        displayHealth(user);
    }

    private void selectAttack(Player user){
        int attack, r;
        String a;
        boolean done = false;

        for(int i = 0; i < 4; i++){
            System.out.print(i + 1 + ". " + user.party[currentID].att[i].getAttackName());
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
                    playerMove(user);
                } else if (attack < -2  || attack > 4 || attack == 0) {
                    System.out.println("Please enter an applicable number!");
                } //else if (PC.getManaLeft() < PC.att.get(attack - 1).getManaCost()){
                    //System.out.println("Not enough mana for this attack! Please enter an applicable number!");
                //}
                else {
                    done = true;
                    selectedMove = attack;
                }
            }

        }

    }

    /**
     * Returns a random element from an arrayList of possible enemy moves, based on the enemy type.
     */
    private void enemyMove(){
        double enemyMove = 1 + Math.random() * (4 - 1);
        enemySelectedMove = (int)enemyMove;
    }

    private int playerAttack(Player user){
        if (selectedMove == 0){
            return 0;
        } else {
            int att = selectedMove - 1;
            double damage;

            //PC.setManaLeft(PC.getManaLeft() - PC.att.get(att).getManaCost());

            damage = playerDamageCalc(att, user);
            damage = Math.round(damage);
            System.out.println("You attack using " + user.party[currentID].att[att].getAttackName() + ". It did " + (int)damage + " damage.");

            if (user.party[currentID].att[att].getPoisonChance() > 0){
                if (getChance() >= user.party[currentID].att[att].getPoisonChance()){
                    isPoisonedEnemy = true;
                    System.out.println("The " + enemy.getName() + " has been poisoned!");
                }
            }
            if (user.party[currentID].att[att].getParalyzChance() > 0){
                if (getChance() >= user.party[currentID].att[att].getParalyzChance()){
                    isParylizedEnemy = true;
                    System.out.println("The " + enemy.getName() + " has been paralyzed!");
                }
            }

            return (int) damage;
        }
    }

    private int playerDamageCalc(int att, Player user){
        int d;
        double damage, multiplier;

        multiplier = getModifier();

        if (user.party[currentID].att[att].getAttackName().equalsIgnoreCase("---")) { //not working
            System.out.println("Invalid Move");
            playerAttack(user);
        }

        if (user.party[currentID].att[att].isPhysical()){
            damage = (2 * user.party[currentID].getLevel() + 10) / 250 * ((user.party[currentID].getAttack() + playerAtkChange) / (enemy.getDefense() + enemyDefChange)) * (user.party[currentID].att[att].getPower() + 2) * multiplier;
            d = (int) damage;
        } else {
            damage = ((2 * user.party[currentID].getLevel() + 10) / 250) * ((user.party[currentID].getSpecialAttack() + playerSpAtkChange) / (enemy.getSpecialDefense() + enemySpDefChange)) * (user.party[currentID].att[att].getPower() + 2) * multiplier;
            d = (int) damage;
        }

        return d;
    }

    private int enemyAttack(Player user){
        if (enemySelectedMove == 0){
            return 0;
        } else{
            int att = enemySelectedMove - 1;
            double damage;
            damage = enemyDamageCalc(user);
            damage = Math.round(damage);
            System.out.println("The " + enemy.getName() + " attacked you using " + enemy.att[att].getAttackName() + ". It did " + (int)damage + " damage.");

            if (enemy.att[att].getPoisonChance() > 0){
                if (getChance() >= enemy.att[att].getPoisonChance()){
                    isPoisonedPlayer = true;
                    System.out.println("You have been poisoned!");
                }
            }
            if (enemy.att[att].getParalyzChance() > 0){
                if (getChance() >= enemy.att[att].getParalyzChance()){
                    isParylizedPlayer = true;
                    System.out.println("You have been paralyzed!");
                }
            }

            return (int) damage;
        }
    }

    private int enemyDamageCalc(Player user){
        double a = Math.random() * 3, multiplier;
        int att = (int) a;
        //att = checkWildAttack(att);

        System.out.println("The wild " + enemy.getName() + " used " + enemy.att[att]);
        double damage;
        multiplier = getModifier();

        if (enemy.att[att].isPhysical()){
            damage = ((2 * enemy.getLevel() + 10) / 250) * ((enemy.getAttack() + enemyAtkChange) / (user.party[0].getDefense() + playerDefChange)) * (enemy.att[att].getPower() + 2) * multiplier;
        } else {
            damage = ((2 * enemy.getLevel() + 10) / 250) * ((enemy.getSpecialAttack() + enemySpAtkChange) / (user.party[0].getSpecialDefense() + playerSpDefChange)) * (enemy.att[att].getPower() + 2) * multiplier;
        }
        damage = (int) Math.round(damage);
        System.out.println("It did " + damage + " damage");

        if (enemy.att[att].getPoisonChance() > 0){
            if (getChance() >= enemy.att[att].getPoisonChance()){
                isPoisonedPlayer = true;
                System.out.println("You have been poisoned!");
            }
        }
        if (enemy.att[att].getParalyzChance() > 0){
            if (getChance() >= enemy.att[att].getParalyzChance()){
                isParylizedPlayer = true;
                System.out.println("You have been paralyzed!");
            }
        }
        int d = (int) damage;

        return d;
    }

    private void displayHealth(Player user){
        System.out.println("LV: " + enemy.getLevel() + " " + enemy.getName());
        System.out.println("HP: " + enemy.getHealthLeft() + "/" + enemy.getHealth());
        System.out.println("LV: " + user.party[currentID].getLevel() + " " + user.party[currentID].getName());
        System.out.println("HP: " + user.party[currentID].getHealth() + "/" + user.party[currentID].getHealth());
    }

    private boolean checkPlayerStatus(Player user){
        return user.party[currentID].getHealthLeft() > 0;
    }

    private boolean checkEnemyStatus(){
        return enemy.getHealthLeft() > 0;
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

    private static int idGenerator(int amount){
        double a;
        int b;

        a = Math.random() * (amount);
        b = (int) Math.round(a);

        return b;
    }

    private double getChance(){
        double chance = 1 + Math.random() * (100 - 1);
        chance = Math.round(chance);

        return chance;
    }

    private double getModifier(){
        double c = getCriticalHitModifier(), r = getRandomMultiplier(), multiplier;
        multiplier = c * r;
        return multiplier;
    }

    private double getRandomMultiplier(){
        double r = .85 + Math.random() * (1 - .85);
        return r;
    }
}
