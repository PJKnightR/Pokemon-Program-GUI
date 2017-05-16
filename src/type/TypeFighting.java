package type;

public class TypeFighting extends Type{
    public static final byte SPOT = 12;

    public TypeFighting(){
        name = "Fighting";
        typeAdvantages = new byte[][]{{TypeDark.SPOT, TypeIce.SPOT, TypeNormal.SPOT, TypeRock.SPOT, TypeSteel.SPOT},{TypeBug.SPOT, TypeDark.SPOT, TypeRock.SPOT}};
        typeNulls = new byte[]{TypeGhost.SPOT};
    }

}