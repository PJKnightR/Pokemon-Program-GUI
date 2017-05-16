package type;

public class TypeDark extends Type{
    public static final byte SPOT = 5;

    public TypeDark(){
        name = "Dark";
        typeAdvantages = new byte[][]{{TypePsychic.SPOT, TypeGhost.SPOT},{SPOT, TypeGhost.SPOT}};
    }

}