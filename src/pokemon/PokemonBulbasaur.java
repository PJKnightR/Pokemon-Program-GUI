package pokemon;

import attack.*;
import type.Type;
import type.TypeGrass;

public class PokemonBulbasaur extends Pokemon{

    public PokemonBulbasaur(int lev){
        name = "Bulbasaur";
        //id = 1;
        pokeNum = 1;
        evolution = new PokemonIvysaur(lev);
        levEv = 16;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeGrass.SPOT)};
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
        spAtkEVG = 1;
        spDefEVG = 1;
        spdEVG = 1;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 49;
        baseDef = 49;
        baseSpAtk = 65;
        baseSpDef = 65;
        baseSpd = 45;
        baseHp = 45;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 3, 7, 13, 13, 15, 19, 21, 25, 27, 31, 33, 37};
        atts = new Attack[]{new AttackTackle(), new AttackGrowl(), new AttackVineWhip(), new AttackPoisonPowder(), new AttackSleepPowder(), new AttackTakeDown(), new AttackRazorLeaf(), new AttackWingAttack(), new AttackSweetScent(), new AttackGrowth(), new AttackDoubleEdge(), new AttackWorrySeed(), new AttackSynthesis(), new AttackSeedBomb()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}