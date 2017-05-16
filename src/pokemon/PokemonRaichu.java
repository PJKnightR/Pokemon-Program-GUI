package pokemon;

import attack.*;
import type.Type;
import type.TypeElectric;

public class PokemonRaichu extends Pokemon{
    public PokemonRaichu(int lev) {
        name = "Raichu";
        //id = 2;
        pokeNum = 26;
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10, 2);
        type = new Type[]{Type.getType(TypeElectric.SPOT)};
        gender = setGender();
        captureRate = 75;
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
        spdEVG = 4;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 90;
        baseDef = 55;
        baseSpAtk = 90;
        baseSpDef = 80;
        baseSpd = 110;
        baseHp = 60;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV / 4) * lev / 100 + 10;

        //attLevel = new int[]{0, 0, 0, 0};
        //atts = new Attack[]{new AttackTailWhip(), new AttackThunderShock(), new AttackQuickAttack(), new AttackThunderbolt()};
        //temporary fix for moveset
        attLevel = new int[]{0, 0, 5, 7, 10, 13, 18, 21, 23, 26, 29, 34, 37, 42, 45, 50, 53, 58};
        atts = new Attack[]{new AttackTailWhip(), new AttackThunderShock(), new AttackGrowl(), new AttackPlayNice(), new AttackQuickAttack(), new AttackElectroBall(), new AttackThunderWave(), new AttackFeint(), new AttackDoubleTeam(), new AttackSpark(), new AttackNuzzle(), new AttackDischarge(), new AttackSlam(), new AttackThunderbolt(), new AttackAgility(), new AttackWildCharge(), new AttackLightScreen(), new AttackThunder()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }
}
