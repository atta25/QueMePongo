import java.awt.*;
import java.util.Collections;

public class Johnson extends Institute {
    @Override
    protected Garment getUpperGarment() {
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.WHITE));
        return new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();
    }

    @Override
    protected Garment getLowerGarment() {
        Material material = new Material(Cloth.SILK, Collections.singletonList(Color.BLACK));
        return new GarmentBuilder().setType(Type.TROUSERS).setMaterial(material).build();
    }

    @Override
    protected Garment getFootwear() {
        Material material = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        return new GarmentBuilder().setType(Type.SHOE).setMaterial(material).build();
    }
}
