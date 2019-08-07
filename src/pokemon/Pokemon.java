package pokemon;

import attack.Attack;
import game.Player;
import item.Item;
import nature.*;
import type.Type;

public abstract class Pokemon{
    protected String name, gender;
    protected double atk, def, spAtk, spDef, spd, hpMax, hp, lev, expMax, exp, levEv, atkEVG, defEVG, spAtkEVG, spDefEVG, spdEVG,
            hpEVG, atkEV, defEV, spAtkEV, spDefEV, spdEV, hpEV, totalEV, atkIV, defIV, spDefIV, spAtkIV, spdIV, hpIV, baseAtk,
            baseDef, baseSpAtk, baseSpDef, baseSpd, baseHp, captureRate;
    protected int pokeNum, attCount, currentAtt;
    public Nature nat;
    public Attack att [] = new Attack[4];
    public Type[] type;
    protected Pokemon evolution;
    public Item held;
    public int attLevel [];
    public Attack atts [];

    public String getName(){
        return(name);
    }

    public void setName(String name){
        this.name = name;
    }

    public int getPokeNum(){
        return pokeNum;
    }

    public void setPokeNum(int pokeNum){
        this.pokeNum = pokeNum;
    }

    public void setEvolution(Pokemon evolution){
        this.evolution = evolution;
    }

    public void setLevEv(double levEv){
        this.levEv = levEv;
    }

    public double getHealth() { return hpMax; }

    public void setHealth(int i){
        hpMax = i;
    }

    /**
     * This method gets Health Left
     */
    public double getHealthLeft() {
        return hp;
    }

    public void setHealthLeft(int i){
        hp = i;
    }

    public double getExperience(){ return exp; }

    public void setExperience(double exp){ this.exp = exp; }

    public double getLevEv(){
        return levEv;
    }

    public Pokemon getEvolution(){
        return evolution;
    }

    public double getAttack(){
        return(atk);
    }

    public void setAttack(double a){
        atk = a;
    }

    public double getDefense(){
        return(def);
    }

    public void setDefense(double d /*hehe double D*/){
        def = d;
    }

    public double getSpecialAttack(){
        return(spAtk);
    }

    public void setSpecialAttack(double a){
        spAtk = a;
    }

    public double getSpecialDefense(){
        return(spDef);
    }

    public void setSpecialDefense(double d /*hehe double D*/){
        spDef = d;
    }

    public double getSpeed(){
        return(spd);
    }

    public void setSpeed(double s){
        spd = s;
    }

    public void setHP(double hp){
        this.hpMax = hp;
    }

    public double getLevel(){
        return(lev);
    }

    public void setLevel(double l){
        lev = l;
    }

    public double getBaseAtk(){
        return baseAtk;
    }

    public void setBaseAtk(double baseAtk){
        this.baseAtk = baseAtk;
    }

    public double getBaseDef(){
        return baseDef;
    }

    public void setBaseDef(double baseDef){
        this.baseDef = baseDef;
    }

    public double getBaseSpAtk(){
        return baseSpAtk;
    }

    public void setBaseSpAtk(double baseSpAtk){
        this.baseSpAtk = baseSpAtk;
    }

    public double getBaseSpDef(){
        return baseSpDef;
    }

    public void setBaseSpDef(double baseSpDef){
        this.baseSpDef = baseSpDef;
    }

    public double getBaseSpd(){
        return baseSpd;
    }

    public void setBaseSpd(double baseSpd){
        this.baseSpd = baseSpd;
    }

    public double getBaseHp(){
        return baseHp;
    }

    public void setBaseHp(double baseHp){
        this.baseHp = baseHp;
    }

    public double getAtkIV(){
        return atkIV;
    }

    public double getAtkEV(){
        return atkEV;
    }

    public double getDefIV(){
        return defIV;
    }

    public double getDefEV(){
        return defEV;
    }

    public double getSpAtkIV(){
        return spAtkIV;
    }

    public double getSpAtkEV(){
        return spAtkEV;
    }

    public double getSpDefIV(){
        return spDefIV;
    }

    public double getSpDefEV(){
        return spDefEV;
    }

    public double getSpdIV(){
        return spdIV;
    }

    public double getSpdEV(){
        return spdEV;
    }

    public double getHpIV(){
        return hpIV;
    }

    public double getHpEV(){
        return hpEV;
    }

    public double getTotalEV(){
        return totalEV;
    }

    public void setAtkEv(double atk){
        this.atkEV = atk;
    }

    public void setDefEv(double def){
        this.defEV = def;
    }

    public void setSpAtkEv(double spAtk){
        this.spAtkEV = spAtk;
    }

    public void setSpDefEv(double spDef){
        this.spDefEV = spDef;
    }

    public void setSpdEv(double spd){
        this.spdEV = spd;
    }

    public void setHpEv(double hp){
        this.hpEV = hp;
    }

    public void setTotalEv(double total){
        this.totalEV = total;
    }

    public String getGenderB(){
        return gender;
    }

    public double getAtkEVG(){
        return (atkEVG);
    }

    public double getDefEVG(){
        return (defEVG);
    }

    public double getSpAtkEVG(){
        return (spAtkEVG);
    }

    public double getSpDefEVG(){
        return (spDefEVG);
    }

    public double getSpdEVG(){
        return (spdEVG);
    }

    public double getHpEVG(){
        return (hpEVG);
    }

    public Type[] getElementType(){
        return(type);
    }

    public void getInitialAttacks(){
        attCount = 0;
        currentAtt = 0;
        while(attLevel[currentAtt] <= lev){
            if (attCount == 4){
                attCount = 0;
            }
            att [attCount] = atts[currentAtt];
            attCount++;
            currentAtt++;
        }
    }

    public int getCurrentAtt(){
        return currentAtt;
    }

    public int getAttCount(){
        return attCount;
    }

    public void setAttCount(int ACount){
        this.attCount = ACount;
    }

    public void setCurrentAtt(int curAtt){
        this.currentAtt = curAtt;
    }

    //public int getID(){
        //return (id);
    //}


    static Pokemon[] getRarityLev1(int lev){
        return new Pokemon[]{new PokemonBulbasaur(lev), new PokemonSquirtle(lev), new PokemonCharmander(lev), new PokemonCaterpie(lev), new PokemonWeedle(lev), new PokemonPidgey(lev), new PokemonRattata(lev), new PokemonSpearow(lev), new PokemonEkans(lev), new PokemonPikachu(lev)};
    }

    static Pokemon[] getRarityLev2(int lev){
        return new Pokemon[]{new PokemonIvysaur(lev), new PokemonWartortle(lev), new PokemonCharmeleon(lev), new PokemonMetapod(lev), new PokemonKakuna(lev), new PokemonPidgeotto(lev), new PokemonRaticate(lev), new PokemonFearow(lev), new PokemonArbok(lev)};
    }

    static Pokemon[] getRarityLev3(int lev){
        return new Pokemon[]{new PokemonVenusaur(lev), new PokemonBlastoise(lev), new PokemonCharizard(lev), new PokemonButterfree(lev), new PokemonBeedrill(lev), new PokemonPidgeot(lev), new PokemonRaichu(lev)};
    }

    static Pokemon[] getStarters(int lev){
        return new Pokemon[]{new PokemonBulbasaur(lev), new PokemonCharmander(lev), new PokemonSquirtle(lev), new PokemonPikachu(lev)};
    }

    static Nature[] getNatures(){
        return new Nature[]{new NatureAdamant(), new NatureBashful(), new NatureBold(), new NatureBrave(), new NatureCalm(), new NatureCareful(), new NatureDocile(), new NatureGentle(), new NatureHardy(), new NatureHasty(), new NatureImpish(), new NatureJolly(), new NatureLax(), new NatureLonely(), new NatureMild(), new NatureModest(), new NatureNaive(), new NatureNaughty(), new NatureQuiet(), new NatureQuirky(), new NatureRash(), new NatureRelaxed(), new NatureSassy(), new NatureSerious(), new NatureTimid()};
    }

    static public Pokemon wildPokemon(Player user){
        int id, amount;
        double chance;
        chance = getChance();
        Pokemon p;
        int lev = levelGenerator(user);

        if (chance <= 60){
            amount = 9;
            id = idGenerator(amount);
            p = getRarityLev1(lev)[id];
        } else if (chance <= 89){
            amount = 8;
            id = idGenerator(amount);
            p = getRarityLev2(lev)[id];
        } else {
            amount = 6;
            id = idGenerator(amount);
            p = getRarityLev3(lev)[id];
        }
        assert p != null;
            p.changeLevel(levelGenerator(user));
        return p;
    }

    static public Pokemon beginnerPokemon(int typ){
        int lev = 5;
        Pokemon p = getStarters(lev)[typ];
        p.changeLevel(5);
        return p;
    }

    static public Pokemon emptySlot(){
        Pokemon p = new PokemonEmpty();
        return p;
    }

    protected Nature natureAssigner(){
        double g;
        int id;
        Nature nate;

        g = Math.random();
        id = (int) Math.round(g) * 24;
        nate = getNatures()[id];

        return nate;
    }

    protected static int levelGenerator(Player user){
        double l;
        int e;

        //l = (1 + Math.random() * (100 - 1));
        //while (l > user.pokemonLevel[0] + 5){
           //l = (1 + Math.random() * (100 - 1));
        //}

        //e = (int) Math.round(l);
        e = 1; //for testing

        return e;
    }

    protected String setGender(){
        int g = genderGenerator();
        if (g == 0){
            gender = "Male";
        } else {
            gender = "Female";
        }
        return gender;
    }

    protected int genderGenerator(){
        double g;
        int v;

        g = Math.random();
        v = (int) Math.round(g);

        return v;
    }

    protected int ivGenerator(){
        double i;
        int v;

        i = Math.random() * 31;
        v = (int) Math.round(i);

        return v;
    }

    private static double getChance(){
        double chance;
        chance = Math.random() * 100;
        chance = Math.round(chance);

        return chance;
    }

    private static int idGenerator(int amount){
        double a;
        int b;

        a = Math.random() * (amount);
        b = (int) Math.round(a);

        return b;
    }

    void changeLevel(int l){
        lev = l;
    }
}