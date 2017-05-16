package type;

public class TypeNormal extends Type{
    public static final byte SPOT = 6;

    public TypeNormal(){
        name = "Normal";
        typeNulls = new byte[]{TypeGhost.SPOT};
    }

}