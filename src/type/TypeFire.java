package type;

public class TypeFire extends Type{
    public static final byte SPOT = 2;

    public TypeFire(){
        name = "Fire";
        typeAdvantages = new byte[][]{{TypeGrass.SPOT, TypeBug.SPOT, TypeIce.SPOT, TypeSteel.SPOT},{TypeGrass.SPOT, SPOT, TypeBug.SPOT, TypeIce.SPOT, TypeSteel.SPOT, TypeFairy.SPOT}};
    }

}