package type;

public class TypeGrass extends Type{
    public static final byte SPOT = 0;

    public TypeGrass(){
        name = "Grass";
        typeAdvantages = new byte[][]{{TypeWater.SPOT, TypeGround.SPOT, TypeRock.SPOT}, {TypeWater.SPOT, SPOT, TypeElectric.SPOT, TypeGround.SPOT}};
    }

}