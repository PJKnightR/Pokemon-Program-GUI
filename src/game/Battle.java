package game;

import pokemon.Pokemon;

import java.util.Scanner;

public class Battle {
    private int currentID;
    private Pokemon wild;
    private Scanner scan;
    private int selectedMove, wildSelectedMove;
    private boolean battling, wildLoss, canRun, isPoisonedPlayer, isPoisonedWild, isParylizedPlayer, isParylizedWild;

    public Battle(){
        isParylizedWild = false;
        isParylizedPlayer = false;
        isPoisonedWild = false;
        isPoisonedPlayer = false;
        battling = true;
        wildLoss = false;
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
        while (battling && !wildLoss){
            if (isPoisonedPlayer){
                if (getChance() > 50){
                    isPoisonedPlayer = false;
                    System.out.println("You are no longer poisoned");
                } else {
                    user.party[currentID].setHealthLeft((int)user.party[currentID].getHealthLeft() - (int)((user.party[currentID].getHealth() * .1) + 1));
                    System.out.println("You took " + (int)((user.party[currentID].getHealth() * .1) + 1) + " damage from poison.");
                    battling = checkPlayerStatus(user.party[currentID]);
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
                    wild.setHealthLeft((int)wild.getHealthLeft() - (int)((wild.getHealth() * .1) + 1));
                    System.out.println("The " + wild.getName() + " took " + (int)((wild.getHealth() * .1) + 1) + " damage from poison.");
                    battling = checkWildStatus();
                    if (!battling){
                        System.out.println("You defeated the " + wild.getName() + "!");
                        wildLoss = true;
                        break;
                    }
                }
            }

            if (battling){
                if(isParylizedPlayer){
                    if (getChance() > 50){
                        isParylizedPlayer = false;
                        System.out.println("You are no longer paralyzed!");
                    }
                }

                if(isParylizedWild){
                    if (getChance() > 50){
                        isParylizedWild = false;
                        System.out.println("The " + wild.getName() + " is no longer paralyzed");
                    }
                }

                if (user.party[currentID].getSpeed() >= wild.getSpeed()){
                    if(isParylizedPlayer){
                        if(getChance() > 50){
                            System.out.println("You are paralyzed but managed to move");
                            wildDamageStep(user.party[currentID]);
                        } else {
                            System.out.println("You are paralyzed and cannot move!");
                        }
                    } else {
                        wildDamageStep(user.party[currentID]);
                    }
                    if(battling){
                        if(isParylizedWild){
                            if(getChance() > 50){
                                System.out.println("The enemy is paralyzed but managed to attack!");
                                playerDamageStep(user.party[currentID]);
                            } else {
                                System.out.println("The enemy is paralyzed and cannot move");
                            }
                        } else {
                            playerDamageStep(user.party[currentID]);
                        }
                    }
                } else if (user.party[currentID].getSpeed() < wild.getSpeed()){
                    if(isParylizedWild){
                        if(getChance() > 50){
                            System.out.println("The enemy is paralyzed but managed to attack!");
                            playerDamageStep(user.party[currentID]);
                        } else {
                            System.out.println("The enemy is paralyzed and cannot move");
                        }
                    } else {
                        playerDamageStep(user.party[currentID]);
                    }

                    if(battling){
                        if(isParylizedPlayer){
                            if(getChance() > 50){
                                System.out.println("You are paralyzed but managed to move");
                                wildDamageStep(user.party[currentID]);
                            } else {
                                System.out.println("You are paralyzed and cannot move!");
                            }
                        } else {
                            wildDamageStep(user.party[currentID]);
                        }
                    }
                }
            }
        }

        if(wildLoss){
            battleEnd(user);
        }
    }

    private void playerDamageStep(Pokemon p){
        p.setHealthLeft(p.getHealthLeft() - wildAttack(p));
        battling = checkPlayerStatus(p);
        if (!battling){
            System.out.println("You were defeated by the " + wild.getName() + "!");
        }
    }

    private void wildDamageStep(Pokemon p){
        wild.setHealthLeft(wild.getHealthLeft() - playerAttack(p));
        battling = checkWildStatus();
        if (!battling){
            System.out.println("The wild " + wild.getName() + " fainted!");
            wildLoss = true;
        }
    }

    public void battleEnd(Player PC){

    }

    private void selectAttack(Player user){
        int attack, r;
        String a;
        boolean done = false;

        for(int i = 0; i < 4; i++){
            System.out.print(i + 1 + ". " + user.party[currentID].att.get(i).getAttackName());
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
            if (r == 0) {
                attack = Integer.parseInt(a);
                if (attack == -1) {
                    done = true;
                    playerMove(user.party[currentID]);
                } else if (attack < -2 || attack > user.party[currentID].att.size() || attack == 0) {
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

    private void playerRun(Player user){
        int run;
        run = (int) getChance();
        if (run > 50){
            System.out.println("Got away safely");
            //game.displayOptionsMenu();
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

            damage = playerDamageCalc(att, user);
            damage = Math.round(damage);
            System.out.println("You attack using " + user.party[currentID].att.get(att).getAttackName() + ". It did " + (int)damage + " damage.");

            if (user.party[currentID].att.get(att).getPoisonChance() > 0){
                if (getChance() >= user.party[currentID].att.get(att).getPoisonChance()){
                    isPoisonedWild = true;
                    System.out.println("The " + wild.getName() + " has been poisoned!");
                }
            }
            if (user.party[currentID].att.get(att).getParalyzChance() > 0){
                if (getChance() >= user.party[currentID].att.get(att).getParalyzChance()){
                    isParylizedWild = true;
                    System.out.println("The " + wild.getName() + " has been paralyzed!");
                }
            }

            return (int) damage;
        }
    }

    private int playerDamageCalc(int att, Player user){
        int d = 0;
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

    private void statDisplay(Pokemon p){
        String i;

        System.out.print("Name: " + p.getName() + " Level: " + p.getLevel() + "\nHealth: " + p.getHealthLeft() + "/"
                + p.getHealth() + ")\nAttack: " + p.getAttack() + ")\nDefense: " + p.getDefense() + ")\nSpeed: "
                + p.getSpeed() + "\nExperience: " + p.getExp() + "/" + 100 * p.getLevel());

        System.out.println("\nEnter -1 to go back");
        i = scan.next();
        while (!i.equals("-1")){
            System.out.println("Please enter a valid number!");
            i = scan.next();
        }
        displayHealth(p);
    }

    private void displayHealth(Pokemon p){
        System.out.println("LV: " + wild.getLevel() + " " + wild.getName());
        System.out.println("HP: " + wild.getHealthLeft() + "/" + wild.getHealth());
        System.out.println("LV: " + p.getLevel() + " " + p.getName());
        System.out.println("HP: " + p.getHealth() + "/" + p.getHealth());
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

        if (wild.att.get(att).getPoisonChance() > 0){
            if (getChance() >= wild.att.get(att).getPoisonChance()){
                isPoisonedPlayer = true;
                System.out.println("You have been poisoned!");
            }
        }
        if (wild.att.get(att).getParalyzChance() > 0){
            if (getChance() >= wild.att.get(att).getParalyzChance()){
                isParylizedPlayer = true;
                System.out.println("You have been paralyzed!");
            }
        }

        user.party[currentID].setHealthLeft(Math.round(user.party[currentID].getHealth() - damage));
        if (user.party[currentID].getHealth() < 0){
            user.party[currentID].setHealthLeft(0);
        }
        displayHealth(user);
        if (user.party [currentID].getHealth() <= 0){//needs to account for whole team.
            playerLose(user);
        } else {
            playerPhase(user);
        }
    }



    /**
     *
     * Utility Methods
     */

    private boolean checkPlayerStatus(Pokemon PC){
        return PC.getHealthLeft() > 0;
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
