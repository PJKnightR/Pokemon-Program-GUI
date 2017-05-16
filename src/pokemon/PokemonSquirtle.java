package pokemon;

import attack.*;
import type.Type;
import type.TypeWater;

public class PokemonSquirtle extends Pokemon{

    public PokemonSquirtle(int lev){
        name = "Squirtle";
        //id = 3;
        pokeNum = 7;
        evolution = new PokemonWartortle(lev);
        levEv = 16;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeWater.SPOT)};
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
        defEVG = 1;
        spAtkEVG = 0;
        spDefEVG = 0;
        spdEVG = 1;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 48;
        baseDef = 65;
        baseSpAtk = 50;
        baseSpDef = 64;
        baseSpd = 43;
        baseHp = 44;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40};
        atts = new Attack[]{new AttackTackle(), new AttackTailWhip(), new AttackWaterGun(), new AttackWithdraw(), new AttackBubble(), new AttackBite(), new AttackRapidSpin(), new AttackProtect(), new AttackWaterPulse(), new AttackAquaTail(), new AttackSkullBash(), new AttackIronDefense(), new AttackRainDance(), new AttackHydroPump()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}