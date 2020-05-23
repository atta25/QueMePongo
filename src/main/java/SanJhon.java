import java.awt.*;
import java.util.Collections;

public class SanJhon extends Institute {
    @Override
    protected Garment getUpperGarment() {
        GarmentBuilder garmentBuilderChomba = new GarmentBuilder();
        garmentBuilderChomba.setType(Type.CHOMBA);
        Material materialChomba = new Material();
        materialChomba.setColors(Collections.singletonList(Color.GREEN));
        materialChomba.setCloth(Cloth.PIQUE);
        garmentBuilderChomba.setMaterial(materialChomba);
        return garmentBuilderChomba.build();
    }

    @Override
    protected Garment getLowerGarment() {
        GarmentBuilder garmentBuilderPantalon = new GarmentBuilder();
        garmentBuilderPantalon.setType(Type.TROUSER);
        Material materialPantalon = new Material();
        materialPantalon.setColors(Collections.singletonList(Color.GRAY));
        materialPantalon.setCloth(Cloth.ACETATE);
        garmentBuilderPantalon.setMaterial(materialPantalon);
        return garmentBuilderPantalon.build();
    }

    @Override
    protected Garment getFootwear() {
        GarmentBuilder garmentBuilderZapatillas = new GarmentBuilder();
        garmentBuilderZapatillas.setType(Type.SNEAKER);
        Material materialZapatillas = new Material();
        materialZapatillas.setColors(Collections.singletonList(Color.WHITE));
        materialZapatillas.setCloth(Cloth.CANVAS);
        garmentBuilderZapatillas.setMaterial(materialZapatillas);
        return garmentBuilderZapatillas.build();
    }
}
