package type;

public class TypeGround extends Type{
    public static final byte SPOT = 14;

    public TypeGround(){
        name = "Ground";
        typeAdvantages = new byte[][]{{TypeFire.SPOT, TypePoison.SPOT, TypeSteel.SPOT, TypeRock.SPOT, TypeElectric.SPOT},{TypePoison.SPOT, TypeRock.SPOT}};
        typeNulls = new byte[]{TypeFlying.SPOT};
    }

}