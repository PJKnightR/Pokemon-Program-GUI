package pokemon;

import attack.*;
import type.Type;
import type.TypePoison;

public class PokemonEkans extends Pokemon{
    public PokemonEkans(int lev){
        name = "Ekans";
        //id = 2;
        pokeNum = 22;
        evolution = new PokemonArbok(lev);
        levEv = 23;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypePoison.SPOT)};
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
        atkEVG = 1;
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

        baseAtk = 60;
        baseDef = 44;
        baseSpAtk = 40;
        baseSpDef = 54;
        baseSpd = 55;
        baseHp = 45;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 4, 9, 12, 17, 20, 25, 25, 25, 28, 33, 36, 38, 41, 44, 49};
        atts = new Attack[]{new AttackWrap(), new AttackLeer(), new AttackPoisonSting(), new AttackBite(), new AttackGlare(), new AttackScreech(), new AttackAcid(), new AttackStockpile(), new AttackSwallow(), new AttackSpitUp(), new AttackAcidSpray(), new AttackMudBomb(),new AttackGastroAcid(), new AttackBelch(), new AttackHaze(), new AttackCoil(), new AttackGunkShot()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }
}

