package type;

public class TypeIce extends Type{
    public final static byte SPOT = 9;

    public TypeIce(){
        name = "Ice";
        typeAdvantages = new byte[][]{{TypeDragon.SPOT, TypeFlying.SPOT, TypeGrass.SPOT, TypeGround.SPOT},{SPOT}};
    }

}