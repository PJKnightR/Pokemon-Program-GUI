package type;

import java.util.ArrayList;

public abstract class Type {
    protected String name;
    //0 = offense, 1 = defense
    protected byte[][] typeAdvantages;
    protected byte[] typeNulls;
    static final double TYPE_ADVANTAGE_MULT = 2, TYPE_DISADVANTAGE_MULT = 0.5;
    static final byte OFFENSE_NUM = 0, DEFENSE_NUM = 1;
    private static Type[] types;

    String getName(){
        return name;
    }

    /**
     * @return Array that holds ALL the types in the game. SPOT variable & bytes reference location in this array
     */
    public static Type[] getTypes(){
        return types;
    }

    /**
     * @param a Index in the Type array
     * @return Single type from the full Type array
     */
    public static Type getType(byte a){
        return types[a];
    }

    /**
     * Function run at the beginning of launch to hold all available types (18 in total)
     */
    public static void initializeTypes(){
        types = new Type[]{new TypeGrass(), new TypeWater(), new TypeFire(), new TypeBug(), new TypeDragon(), new TypeDark(), new TypeNormal(), new TypeFlying(), new TypePoison(), new TypeIce(), new TypePsychic(), new TypeSteel(), new TypeFighting(),
                new TypeGhost(), new TypeGround(), new TypeRock(), new TypeElectric(), new TypeFairy()};
    }

    /**
     * @return Array that holds any type that this type is advantageous when fighting against it
     */
    public Type[] getTypeAdvantagesOffensive(){
        ArrayList<Type> hold = new ArrayList<>();
        for(byte i : typeAdvantages[OFFENSE_NUM]){
            hold.add(getTypes()[i]);
        }
        return hold.toArray(new Type[hold.size()]);
    }

    /**
     * @return Number of types this type is advantageous against when fighting it
     */
    public int getTypeAdvantageOffensiveNum(){
        return typeAdvantages[OFFENSE_NUM].length;
    }

    /**
     * @return Array that holds any type that this type is advantageous when defending from it
     */
    Type[] getTypeAdvantagesDefensive(){
        ArrayList<Type> hold = new ArrayList<>();
        for(byte i : typeAdvantages[DEFENSE_NUM]){
            hold.add(getTypes()[i]);
        }
        return hold.toArray(new Type[hold.size()]);
    }

    /**
     * @return The number of types this type  is advantageous against when defending from it
     */
    public int getTypeAdvantageDefensiveNum(){
        return typeAdvantages[DEFENSE_NUM].length;
    }

    /**
     * @return Array that holds the types this type cannot harm
     */
    public Type[] getTypeNulls(){
        ArrayList<Type> hold = new ArrayList<>();
        for(byte i : typeNulls){
            hold.add(getTypes()[i]);
        }
        return hold.toArray(new Type[hold.size()]);
    }

    /**
     * @return Number of types this type cannot harm
     */
    public int getTypeNullsNum(){
        return typeNulls.length;
    }

    public String toString(){
        return name;
    }
}