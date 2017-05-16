package type;

public class TypeElectric extends Type{
    public static final byte SPOT = 16;

    public TypeElectric(){
        name = "Electric";
        typeAdvantages = new byte[][]{{TypeFlying.SPOT, TypeWater.SPOT},{SPOT, TypeFlying.SPOT, TypeSteel.SPOT}};
        typeNulls = new byte[]{TypeGround.SPOT};
    }

}