package type;

public class TypeBug extends Type{
    public static final byte SPOT = 3;

    public TypeBug(){
        name = "Bug";
        typeAdvantages = new byte[][]{{TypeGrass.SPOT, TypeDark.SPOT, TypePsychic.SPOT}, {TypeGrass.SPOT, TypeFighting.SPOT, TypeGround.SPOT}};
    }

}