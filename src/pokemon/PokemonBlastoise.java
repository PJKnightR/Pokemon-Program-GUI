package pokemon;

import attack.*;
import type.Type;
import type.TypeWater;

public class PokemonBlastoise extends Pokemon{

    public PokemonBlastoise(int lev){
        name = "Blastoise";
        //id = 3;
        pokeNum = 9;
        evolution = null;
        levEv = 101;
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
        defEVG = 0;
        spAtkEVG = 0;
        spDefEVG = 3;
        spdEVG = 1;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 83;
        baseDef = 100;
        baseSpAtk = 85;
        baseSpDef = 105;
        baseSpd = 78;
        baseHp = 79;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 4, 7, 10, 13, 17, 21, 25, 29, 33, 40, 47, 54, 60};
        atts = new Attack[]{new AttackTackle(), new AttackTailWhip(), new AttackWaterGun(), new AttackWithdraw(), new AttackBubble(), new AttackBite(), new AttackRapidSpin(), new AttackProtect(), new AttackWaterPulse(), new AttackAquaTail(), new AttackSkullBash(), new AttackIronDefense(), new AttackRainDance(), new AttackHydroPump()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}