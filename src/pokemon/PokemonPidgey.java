package pokemon;

import attack.*;
import type.Type;
import type.TypeFlying;
import type.TypeNormal;

public class PokemonPidgey extends Pokemon{

    public PokemonPidgey(int lev){
        name = "Pidgey";
        //id = 1;
        pokeNum = 16;
        evolution = new PokemonPidgeotto(lev);
        levEv = 18;
        expMax = Math.pow(lev * 10 , 2);
        type = new Type[]{Type.getType(TypeNormal.SPOT), Type.getType(TypeFlying.SPOT)};
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

        baseAtk = 45;
        baseDef = 40;
        baseSpAtk = 35;
        baseSpDef = 35;
        baseSpd = 56;
        baseHp = 40;

        atk = ((baseAtk * 2 + atkIV + atkEV / 4) * lev / 100 + 5) * nat.getAtkBonus();
        def = ((baseDef * 2 + defIV + defEV / 4) * lev / 100 + 5) * nat.getDefBonus();
        spAtk = ((baseSpAtk * 2 + spAtkIV + spAtkEV / 4) * lev / 100 + 5) * nat.getSpAtkBonus();
        spDef = ((baseSpDef * 2 + spDefIV + spDefEV / 4) * lev / 100 + 5) * nat.getSpDefBonus();
        spd = ((baseSpd * 2 + spdIV + spdEV / 4) * lev / 100 + 5) * nat.getSpdBonus();
        hpMax = (baseHp * 2 + hpIV + hpEV  / 4) * lev / 100 + 10;

        attLevel = new int[]{0, 5, 9, 13, 17, 21, 25, 29, 33, 37, 41, 45, 49, 53};
        atts = new Attack[]{new AttackTackle(), new AttackSandAttack(), new AttackGust(), new AttackQuickAttack(), new AttackWhirlwind(), new AttackTwister(), new AttackFeatherDance(), new AttackAgility(), new AttackWingAttack(), new AttackRoost(), new AttackTailWind(), new AttackMirrorMove(), new AttackAirSlash(), new AttackHurricane()};
        att = new Attack[]{new AttackEmpty(), new AttackEmpty(), new AttackEmpty(), new AttackEmpty()};
        getInitialAttacks();
    }

}