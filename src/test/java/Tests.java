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
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment garment = new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();

        assertEquals(Type.SHIRT, garment.getType());
        assertEquals(Cloth.COTTON, garment.getMaterial().getCloth());
        assertEquals(Plot.SMOOTH, garment.getMaterial().getPlot());
        assertTrue(garment.getMaterial().getColors().contains(Color.BLACK));
    }

    @Test(expected = BuildGarmentException.class)
    public void whenTypeAndClothAreInconsistentShouldThrowAnException() {
        Material material = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();
    }

    @Test
    public void buildUniform() {
        Material shirtMaterial = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment shirt = new GarmentBuilder().setType(Type.SHIRT).setMaterial(shirtMaterial).build();

        Material trousersMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();

        Material shoesMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment shoes = new GarmentBuilder().setType(Type.SHOE).setMaterial(shoesMaterial).build();

        Uniform uniform = new Uniform(shirt, trousers, shoes);
        assertEquals(shirt, uniform.getUpperGarment());
        assertEquals(trousers, uniform.getLowerGarment());
        assertEquals(shoes, uniform.getFootwear());
    }

    @Test
    public void whenThereAreACoupleOfCombinationsShouldHaveACoupleOfSuggestions() {
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment shirt = new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();

        Material trousersMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();

        Material shoesMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment shoes = new GarmentBuilder().setType(Type.SHOE).setMaterial(shoesMaterial).build();

        Material sneakersMaterial = new Material(Cloth.CANVAS, Collections.singletonList(Color.BLACK));
        Garment sneakers = new GarmentBuilder().setType(Type.SNEAKER).setMaterial(sneakersMaterial).build();

        Set<Garment> garments = new HashSet<>(Arrays.asList(shirt, trousers, shoes, sneakers));
        AccuProvider accuProviderMock = mock(AccuProvider.class);
        when(accuProviderMock.getWeather("BsAs")).thenReturn(24.0);
        AttireGenerator generator = new AttireGenerator(accuProviderMock);

        Set<Attire> attires = generator.getSuggestions(garments);

        List<Attire> attiresList = Lists.newArrayList(attires);
        assertEquals(2, attiresList.size());
        List<Garment> firstSetOfClothes = Lists.newArrayList(attiresList.get(0).getGarments());
        assertEquals(3, firstSetOfClothes.size());
        assertTrue(firstSetOfClothes.contains(shirt));
        assertTrue(firstSetOfClothes.contains(trousers));
        assertTrue((firstSetOfClothes.contains(shoes) && !firstSetOfClothes.contains(sneakers)) ||
                            (firstSetOfClothes.contains(sneakers) && !firstSetOfClothes.contains(shoes)));
        List<Garment> secondSetOfClothes = Lists.newArrayList(attiresList.get(1).getGarments());
        assertEquals(3, firstSetOfClothes.size());
        assertTrue(secondSetOfClothes.contains(shirt));
        assertTrue(secondSetOfClothes.contains(trousers));
        assertTrue((secondSetOfClothes.contains(shoes) && !secondSetOfClothes.contains(sneakers)) ||
                (secondSetOfClothes.contains(sneakers) && !secondSetOfClothes.contains(shoes)));
    }

    @Test
    public void mockAccuProviderResponse() {
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment shirt = new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();

        Material trousersMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();

        Material shoesMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment shoes = new GarmentBuilder().setType(Type.SHOE).setMaterial(shoesMaterial).build();
        Set<Garment> garments = new HashSet<>(Arrays.asList(shirt, trousers, shoes));
        AccuProvider accuProviderMock = mock(AccuProvider.class);
        when(accuProviderMock.getWeather("BsAs")).thenReturn(24.0);
        AttireGenerator generator = new AttireGenerator(accuProviderMock);

        Set<Attire> attires = generator.getSuggestions(garments);

        List<Attire> attiresList = Lists.newArrayList(attires);
        assertEquals(1, attiresList.size());
    }
}
