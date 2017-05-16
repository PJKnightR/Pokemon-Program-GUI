package type;

public class TypeGhost extends Type{
    public static final byte SPOT = 13;

    public TypeGhost(){
        name = "Ghost";
        typeAdvantages = new byte[][]{{SPOT, TypePsychic.SPOT},{TypeBug.SPOT, TypePoison.SPOT}};
        typeNulls = new byte[]{TypeNormal.SPOT};
    }

}