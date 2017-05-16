package pokemon;

import attack.*;
import type.Type;
import type.TypeBug;
import type.TypePoison;

public class PokemonBeedrill extends Pokemon{

    public PokemonBeedrill(int lev){
        name = "Beedrill";
        //id = 4;
        pokeNum = 15; //for the pokedex
        evolution = null;
        levEv = 101;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeBug.SPOT), Type.getType(TypePoison.SPOT)};
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
        atkEVG = 2;
        defEVG = 0;
        spAtkEVG = 0;
        spDefEVG = 1;
        spdEVG = 1;

        hpEV = 0;
        atkEV = 0;
        defEV = 0;
        spAtkEV = 0;
        spDefEV = 0;
        spdEV = 0;
        totalEV = 0;

        baseAtk = 90;
        baseDef = 40;
        baseSpAtk = 45;
        baseSpDef = 80;
        baseSpd = 75;
        baseHp = 65;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 0, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44};
        atts = new Attack[]{new AttackPoisonSting(), new AttackStringShot(), new AttackHarden(), new AttackFuryAttack(), new AttackRage(), new AttackPursuit(), new AttackFocusEnergy(), new AttackVenoshock(), new AttackAssurance(), new AttackToxicSpikes(), new AttackPinMissle(), new AttackPoisonJab(), new AttackAgility(), new AttackEndeavor(), new AttackFellStinger()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}