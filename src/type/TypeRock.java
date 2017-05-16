package type;

public class TypeRock extends Type{
    public static final byte SPOT = 15;

    public TypeRock(){
        name = "Rock";
        typeAdvantages = new byte[][]{{TypeBug.SPOT, TypeFlying.SPOT, TypeFire.SPOT, TypeIce.SPOT},{TypeFire.SPOT, TypeFlying.SPOT, TypeNormal.SPOT, TypePoison.SPOT}};
    }

}