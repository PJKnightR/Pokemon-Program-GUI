package pokemon;

import attack.*;
import type.Type;
import type.TypeElectric;

public class PokemonPikachu extends Pokemon{
    public PokemonPikachu(int lev) {
        name = "Pikachu";
        //id = 2;
        pokeNum = 25;
        evolution = new PokemonRaichu(lev);
        levEv = 30;
        expMax = Math.pow(lev * 10, 2);
        type = new Type[]{Type.getType(TypeElectric.SPOT)};
        gender = setGender();
        captureRate = 190;
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

        baseAtk = 55;
        baseDef = 40;
        baseSpAtk = 50;
        baseSpDef = 50;
        baseSpd = 90;
        baseHp = 35;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 5, 7, 10, 13, 18, 21, 23, 26, 29, 34, 37, 42, 45, 50, 53, 58};
        atts = new Attack[]{new AttackTailWhip(), new AttackThunderShock(), new AttackGrowl(), new AttackPlayNice(), new AttackQuickAttack(), new AttackElectroBall(), new AttackThunderWave(), new AttackFeint(), new AttackDoubleTeam(), new AttackSpark(), new AttackNuzzle(), new AttackDischarge(), new AttackSlam(), new AttackThunderbolt(), new AttackAgility(), new AttackWildCharge(), new AttackLightScreen(), new AttackThunder()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }
}
