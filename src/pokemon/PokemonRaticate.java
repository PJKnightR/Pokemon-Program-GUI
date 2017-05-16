package pokemon;

import attack.*;
import type.Type;
import type.TypeNormal;


public class PokemonRaticate extends Pokemon{
    public PokemonRaticate(int lev){
        name = "Raticate";
        //id = 2;
        pokeNum = 20;
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeNormal.SPOT)};
        gender = setGender();
        captureRate = 127;
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
        spAtkEVG = 0;
        spDefEVG = 0;
        spdEVG = 3;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 81;
        baseDef = 60;
        baseSpAtk = 50;
        baseSpDef = 70;
        baseSpd = 97;
        baseHp = 55;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 4, 7, 10, 13, 16, 19, 24, 29, 34, 39, 44};
        atts = new Attack[]{new AttackTackle(), new AttackTailWhip(), new AttackQuickAttack(), new AttackFocusEnergy(), new AttackBite(), new AttackPursuit(), new AttackHyperFang(), new AttackAssurance(), new AttackCrunch(), new AttackSuckerPunch(), new AttackSuperFang(), new AttackDoubleEdge(), new AttackEndeavor()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }
}
