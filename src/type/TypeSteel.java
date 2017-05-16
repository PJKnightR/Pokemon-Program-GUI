package type;

public class TypeSteel extends Type{
    public static final byte SPOT = 11;

    public TypeSteel(){
        name = "Steel";
        typeAdvantages = new byte[][]{{TypeIce.SPOT, TypeRock.SPOT, TypeFairy.SPOT},{TypeBug.SPOT, TypeDragon.SPOT, TypeFairy.SPOT, TypeFlying.SPOT, TypeGrass.SPOT, TypeIce.SPOT, TypeNormal.SPOT, TypePsychic.SPOT, TypeRock.SPOT, SPOT}};
    }

}