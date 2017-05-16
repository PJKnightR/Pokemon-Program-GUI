package pokemon;

import attack.*;
import type.Type;
import type.TypeNormal;

public class PokemonRattata extends Pokemon{
    public PokemonRattata(int lev){
        name = "Rattata";
        //id = 2;
        pokeNum = 19;
        evolution = new PokemonRaticate(lev);
        levEv = 20;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeNormal.SPOT)};
        gender = setGender();
        captureRate = 255;
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
        spdEVG = 2;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 56;
        baseDef = 35;
        baseSpAtk = 25;
        baseSpDef = 35;
        baseSpd = 72;
        baseHp = 30;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};
        atts = new Attack[]{new AttackTackle(), new AttackTailWhip(), new AttackQuickAttack(), new AttackFocusEnergy(), new AttackBite(), new AttackPursuit(), new AttackHyperFang(), new AttackAssurance(), new AttackCrunch(), new AttackSuckerPunch(), new AttackSuperFang(), new AttackDoubleEdge(), new AttackEndeavor()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }
}
