package type;

public class TypeWater extends Type{
    public static final byte SPOT = 1;

    public TypeWater(){
        name = "Water";
        typeAdvantages = new byte[][]{{TypeFire.SPOT, TypeGround.SPOT, TypeRock.SPOT},{TypeFire.SPOT, SPOT, TypeIce.SPOT, TypeSteel.SPOT}};
    }

}