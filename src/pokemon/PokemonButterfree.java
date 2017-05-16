package pokemon;

import attack.*;
import type.Type;
import type.TypeBug;
import type.TypeFlying;

public class PokemonButterfree extends Pokemon{

    public PokemonButterfree(int lev){
        name = "Butterfree";
        //id = 4;
        pokeNum = 12;
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeBug.SPOT), Type.getType(TypeFlying.SPOT)};
        gender = setGender();
        captureRate = 45;
        nat = natureAssigner();

        atkIV = ivGenerator();
        defIV = ivGenerator();
        spAtkIV = ivGenerator();
        spDefIV = ivGenerator();
        spdIV = ivGenerator();
        hpIV = ivGenerator();

        hpEVG = 0;
        atkEVG = 0;
        defEVG = 0;
        spAtkEVG = 2;
        spDefEVG = 1;
        spdEVG = 1;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 45;
        baseDef = 50;
        baseSpAtk = 90;
        baseSpDef = 80;
        baseSpd = 70;
        baseHp = 60;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 9, 11, 11, 13, 13, 13, 17, 19, 23, 25, 29, 31, 35, 37, 41, 43, 47};
        atts = new Attack[]{new AttackTackle(), new AttackStringShot(), new AttackBugBite(), new AttackGust(), new AttackConfusion(), new AttackPoisonPowder(), new AttackStunSpore(), new AttackSleepPowder(), new AttackPsybeam(), new AttackSilverWind(), new AttackSupersonic(), new AttackSafeguard(), new AttackWhirlwind(), new AttackBugBuzz(), new AttackRagePowder(), new AttackCaptivate(), new AttackTailWind(), new AttackAirSlash(), new AttackQuiverDance()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}