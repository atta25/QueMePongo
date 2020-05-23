import java.awt.*;
import java.util.Collections;

public class Johnson extends Institute {
    @Override
    protected Garment getUpperGarment() {
        GarmentBuilder builder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.WHITE));
        material.setCloth(Cloth.COTTON);
        return builder.setType(Type.SHIRT).setMaterial(material).build();
    }

    @Override
    protected Garment getLowerGarment() {
        GarmentBuilder builder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.BLACK));
        material.setCloth(Cloth.SILK);
        return builder.setType(Type.TROUSER).setMaterial(material).build();
    }

    @Override
    protected Garment getFootwear() {
        GarmentBuilder builder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.BLACK));
        material.setCloth(Cloth.LEATHER);
        return builder.setType(Type.SHOE).setMaterial(material).build();
    }
}
