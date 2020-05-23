import com.google.common.collect.Lists;
import org.junit.Test;
import java.awt.*;
import java.util.*;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Tests {
    @Test
    public void buildGarment() {
        GarmentBuilder garmentBuilder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.BLACK));
        material.setCloth(Cloth.COTTON);
        Garment garment = garmentBuilder.setType(Type.SHIRT).setMaterial(material).build();

        assertEquals(Type.SHIRT, garment.getType());
        assertTrue(garment.getMaterial().getColors().contains(Color.BLACK));
        assertEquals(Cloth.COTTON, garment.getMaterial().getCloth());
        assertEquals(Plot.SMOOTH, garment.getMaterial().getPlot());
    }

    @Test(expected = BuildGarmentException.class)
    public void whenTypeAndClothAreInconsistentShouldThrowAnException() {
        GarmentBuilder builder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.BLACK));
        material.setCloth(Cloth.LEATHER);
        builder.setType(Type.SHIRT).setMaterial(material).build();
    }

    @Test
    public void buildUniform() {
        GarmentBuilder shirtGarmentBuilder = new GarmentBuilder();
        Material shirtMaterial = new Material();
        shirtMaterial.setColors(Collections.singletonList(Color.BLACK));
        shirtMaterial.setCloth(Cloth.COTTON);
        Garment shirt = shirtGarmentBuilder.setType(Type.SHIRT).setMaterial(shirtMaterial).build();

        GarmentBuilder trouserGarmentBuilder = new GarmentBuilder();
        Material trouserMaterial = new Material();
        trouserMaterial.setColors(Collections.singletonList(Color.BLACK));
        trouserMaterial.setCloth(Cloth.LEATHER);
        Garment trouser = trouserGarmentBuilder.setType(Type.TROUSER).setMaterial(trouserMaterial).build();

        GarmentBuilder shoesGarmentBuilder = new GarmentBuilder();
        Material shoesMaterial = new Material();
        shoesMaterial.setColors(Collections.singletonList(Color.BLACK));
        shoesMaterial.setCloth(Cloth.LEATHER);
        Garment shoes = shoesGarmentBuilder.setType(Type.SHOE).setMaterial(shoesMaterial).build();

        Uniform uniform = new Uniform(shirt, trouser, shoes);
        assertEquals(shirt, uniform.getUpperGarment());
        assertEquals(trouser, uniform.getLowerGarment());
        assertEquals(shoes, uniform.getFootwear());
    }

    @Test(expected = BuildUniformException.class)
    public void whenTheUniformDoesNotHaveTheMandatoryCategoriesShouldThrowAnException() {
        GarmentBuilder shirtGarmentBuilder = new GarmentBuilder();
        shirtGarmentBuilder.setType(Type.SHIRT);
        Material shirtMaterial = new Material();
        shirtMaterial.setColors(Collections.singletonList(Color.BLACK));
        shirtMaterial.setCloth(Cloth.COTTON);
        shirtGarmentBuilder.setMaterial(shirtMaterial);
        Garment shirt = shirtGarmentBuilder.build();

        GarmentBuilder trouserGarmentBuilder = new GarmentBuilder();
        trouserGarmentBuilder.setType(Type.TROUSER);
        Material trouserMaterial = new Material();
        trouserMaterial.setColors(Collections.singletonList(Color.BLACK));
        trouserMaterial.setCloth(Cloth.LEATHER);
        trouserGarmentBuilder.setMaterial(trouserMaterial);
        Garment trouser = trouserGarmentBuilder.build();

        new Uniform(shirt, shirt, trouser);
    }

    @Test
    public void whenThereAreACoupleOfCombinationsShouldHaveACoupleOfSuggestions() {
        GarmentBuilder shirtGarmentBuilder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.BLACK));
        material.setCloth(Cloth.COTTON);
        material.setPlot(Plot.SMOOTH);
        Garment shirt = shirtGarmentBuilder.setType(Type.SHIRT).setMaterial(material).build();

        GarmentBuilder trouserGarmentBuilder = new GarmentBuilder();
        Material trouserMaterial = new Material();
        trouserMaterial.setColors(Collections.singletonList(Color.BLACK));
        trouserMaterial.setCloth(Cloth.LEATHER);
        Garment trouser = trouserGarmentBuilder.setType(Type.TROUSER).setMaterial(trouserMaterial).build();

        GarmentBuilder shoesGarmentBuilder = new GarmentBuilder();
        Material shoesMaterial = new Material();
        shoesMaterial.setColors(Collections.singletonList(Color.BLACK));
        shoesMaterial.setCloth(Cloth.LEATHER);
        Garment shoes = shoesGarmentBuilder.setType(Type.SHOE).setMaterial(shoesMaterial).build();

        GarmentBuilder sneakersGarmentBuilder = new GarmentBuilder();
        Material sneakersMaterial = new Material();
        sneakersMaterial.setColors(Collections.singletonList(Color.BLACK));
        sneakersMaterial.setCloth(Cloth.CANVAS);
        Garment sneakers = sneakersGarmentBuilder.setType(Type.SNEAKER).setMaterial(sneakersMaterial).build();

        Set<Garment> garments = new HashSet<>(Arrays.asList(shirt, trouser, shoes, sneakers));

        AttireGenerator generator = new AttireGenerator();
        Set<Attire> attires = generator.getSuggestions(garments, 24.0);

        List<Attire> attiresList = Lists.newArrayList(attires);
        assertEquals(2, attiresList.size());
        List<Garment> firstSetOfClothes = Lists.newArrayList(attiresList.get(0).getGarments());
        assertEquals(3, firstSetOfClothes.size());
        assertTrue(firstSetOfClothes.contains(shirt));
        assertTrue(firstSetOfClothes.contains(trouser));
        assertTrue((firstSetOfClothes.contains(shoes) && !firstSetOfClothes.contains(sneakers)) ||
                            (firstSetOfClothes.contains(sneakers) && !firstSetOfClothes.contains(shoes)));
        List<Garment> secondSetOfClothes = Lists.newArrayList(attiresList.get(1).getGarments());
        assertEquals(3, firstSetOfClothes.size());
        assertTrue(secondSetOfClothes.contains(shirt));
        assertTrue(secondSetOfClothes.contains(trouser));
        assertTrue((secondSetOfClothes.contains(shoes) && !secondSetOfClothes.contains(sneakers)) ||
                (secondSetOfClothes.contains(sneakers) && !secondSetOfClothes.contains(shoes)));
    }

    @Test
    public void mockAccuProviderResponse() {
        GarmentBuilder shirtGarmentBuilder = new GarmentBuilder();
        Material material = new Material();
        material.setColors(Collections.singletonList(Color.BLACK));
        material.setCloth(Cloth.COTTON);
        material.setPlot(Plot.SMOOTH);
        Garment shirt = shirtGarmentBuilder.setType(Type.SHIRT).setMaterial(material).build();

        GarmentBuilder trouserGarmentBuilder = new GarmentBuilder();
        Material trouserMaterial = new Material();
        trouserMaterial.setColors(Collections.singletonList(Color.BLACK));
        trouserMaterial.setCloth(Cloth.LEATHER);
        Garment trouser = trouserGarmentBuilder.setType(Type.TROUSER).setMaterial(trouserMaterial).build();

        GarmentBuilder shoesGarmentBuilder = new GarmentBuilder();
        Material shoesMaterial = new Material();
        shoesMaterial.setColors(Collections.singletonList(Color.BLACK));
        shoesMaterial.setCloth(Cloth.LEATHER);
        Garment shoes = shoesGarmentBuilder.setType(Type.SHOE).setMaterial(shoesMaterial).build();

        Set<Garment> garments = new HashSet<>(Arrays.asList(shirt, trouser, shoes));

        AccuProviderAdapter accuProviderAdapterMock = mock(AccuProviderAdapter.class);
        when(accuProviderAdapterMock.getWeather("BsAs")).thenReturn(24.0);
        Pronostic pronostic = new Pronostic(accuProviderAdapterMock);
        Double temperature = pronostic.getTemperature("BsAs");

        AttireGenerator generator = new AttireGenerator();
        Set<Attire> attires = generator.getSuggestions(garments, temperature);
        List<Attire> attiresList = Lists.newArrayList(attires);
        assertEquals(1, attiresList.size());
    }
}
