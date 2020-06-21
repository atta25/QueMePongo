package factory;

import builder.GarmentBuilder;
import domain.Cloth;
import domain.Garment;
import domain.Material;
import domain.Type;
import java.awt.*;
import java.util.Collections;

public class SanJhon extends Institute {
    @Override
    protected Garment getUpperGarment() {
        Material material = new Material(Cloth.PIQUE, Collections.singletonList(Color.GREEN));
        return new GarmentBuilder().setType(Type.CHOMBA).setMaterial(material).build();
    }

    @Override
    protected Garment getLowerGarment() {
        Material material = new Material(Cloth.ACETATE, Collections.singletonList(Color.GRAY));
        return new GarmentBuilder().setType(Type.TROUSERS).setMaterial(material).build();
    }

    @Override
    protected Garment getFootwear() {
        Material material = new Material(Cloth.CANVAS, Collections.singletonList(Color.WHITE));
        return new GarmentBuilder().setType(Type.SNEAKER).setMaterial(material).build();
    }
}
