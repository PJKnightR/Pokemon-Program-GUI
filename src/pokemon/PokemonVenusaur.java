package pokemon;

import attack.*;
import type.Type;
import type.TypeGrass;
import type.TypePoison;

public class PokemonVenusaur extends Pokemon{

    public PokemonVenusaur(int lev){
        name = "Venusaur";
        //id = 1;
        pokeNum = 3;
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeGrass.SPOT), Type.getType(TypePoison.SPOT)};
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

        baseAtk = 82;
        baseDef = 83;
        baseSpAtk = 100;
        baseSpDef = 100;
        baseSpd = 80;
        baseHp = 80;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 3, 7, 9, 13, 13, 15, 20, 23, 28, 31, 37, 39, 45, 50, 53};
        atts = new Attack[]{new AttackTackle(), new AttackGrowl(), new AttackLeechSeed(), new AttackVineWhip(), new AttackPoisonPowder(), new AttackSleepPowder(), new AttackTakeDown(), new AttackRazorLeaf(), new AttackWingAttack(), new AttackSweetScent(), new AttackGrowth(), new AttackDoubleEdge(), new AttackPetalDance(), new AttackWorrySeed(), new AttackSynthesis(), new AttackPetalBlizzard(), new AttackSolarbeam()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}