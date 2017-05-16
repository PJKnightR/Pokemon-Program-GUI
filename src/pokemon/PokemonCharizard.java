package pokemon;

import attack.*;
import type.Type;
import type.TypeFire;
import type.TypeFlying;

public class PokemonCharizard extends Pokemon{

    public PokemonCharizard(int lev){
        name = "Charizard";
        //id = 2;
        pokeNum = 6;
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeFire.SPOT), Type.getType(TypeFlying.SPOT)};
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
        spAtkEVG = 3;
        spDefEVG = 0;
        spdEVG = 1;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 84;
        baseDef = 78;
        baseSpAtk = 109;
        baseSpDef = 85;
        baseSpd = 100;
        baseHp = 78;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 7, 10, 16, 21, 28, 32, 37, 41, 47, 56, 62, 71, 77};
        atts = new Attack[]{new AttackScratch(), new AttackGrowl(), new AttackEmber(), new AttackSmokescreen(), new AttackDragonRage(), new AttackScaryFace(), new AttackFireFang(), new AttackFlameBurst(), new AttackWingAttack(), new AttackSlash(), new AttackFlamethrower(), new AttackFireSpin(), new AttackInferno(), new AttackHeatWave(), new AttackFlareBlitz()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}