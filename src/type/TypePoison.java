package type;

public class TypePoison extends Type{
    public final static byte SPOT = 8;

    public TypePoison(){
        name = "Poison";
        typeAdvantages = new byte[][]{{TypeGrass.SPOT, TypeFairy.SPOT},{SPOT, TypeBug.SPOT, TypeGrass.SPOT, TypeFighting.SPOT, TypeFairy.SPOT}};
        typeNulls = new byte[]{TypeSteel.SPOT};
    }

}