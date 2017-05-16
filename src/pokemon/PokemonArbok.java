package pokemon;

import attack.*;
import type.Type;
import type.TypePoison;

public class PokemonArbok extends Pokemon{
    public PokemonArbok(int lev){
        name = "Ekans";
        //id = 2;
        pokeNum = 24;
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypePoison.SPOT)};
        gender = setGender();
        captureRate = 90;
        nat = natureAssigner();

        atkIV = ivGenerator();
        defIV = ivGenerator();
        spAtkIV = ivGenerator();
        spDefIV = ivGenerator();
        spdIV = ivGenerator();
        hpIV = ivGenerator();

        hpEVG = 0;
        atkEVG = 2;
        defEVG = 0;
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

        baseAtk = 95;
        baseDef = 69;
        baseSpAtk = 65;
        baseSpDef = 79;
        baseSpd = 80;
        baseHp = 60;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 4, 9, 12, 17, 20, 27, 27, 27, 32, 39, 44, 48, 51, 56, 63};
        atts = new Attack[]{new AttackWrap(), new AttackLeer(), new AttackPoisonSting(), new AttackBite(), new AttackGlare(), new AttackScreech(), new AttackAcid(), new AttackStockpile(), new AttackSwallow(), new AttackSpitUp(), new AttackAcidSpray(), new AttackMudBomb(),new AttackGastroAcid(), new AttackBelch(), new AttackHaze(), new AttackCoil(), new AttackGunkShot()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }
}
