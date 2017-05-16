package type;

public class TypePsychic extends Type{
    public final static byte SPOT = 10;

    public TypePsychic(){
        name = "Psychic";
        typeAdvantages = new byte[][]{{TypePoison.SPOT, TypeFighting.SPOT}, {SPOT, TypeFighting.SPOT}};
        typeNulls = new byte[]{TypeDark.SPOT};
    }

}