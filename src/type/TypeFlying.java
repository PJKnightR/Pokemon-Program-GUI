package type;

public class TypeFlying extends Type{
    public static final byte SPOT = 7;

    public TypeFlying(){
        name = "Flying";
        typeAdvantages = new byte[][]{{TypeBug.SPOT, TypeGrass.SPOT, TypeFighting.SPOT},{TypeBug.SPOT, TypeGrass.SPOT, TypeFighting.SPOT}};
    }

}