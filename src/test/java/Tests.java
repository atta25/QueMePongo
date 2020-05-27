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
        Wardrobe wardrobe = new Wardrobe(garments);
        WeatherProvider weatherProviderMock = mock(WeatherProvider.class);
        when(weatherProviderMock.getWeather("BsAs")).thenReturn(24.0);
        AttireGenerator generator = new AttireGenerator(weatherProviderMock);

        Set<Attire> attires = generator.getSuggestions(wardrobe);

        assertEquals(2, attires.size());

        Set<Garment> firstSetOfGarments = attires.iterator().next().getGarments();
        assertEquals(3, firstSetOfGarments.size());
        assertTrue(wardrobe.containsAll(firstSetOfGarments));

        Set<Garment> secondSetOfGarments = attires.iterator().next().getGarments();
        assertEquals(3, secondSetOfGarments.size());
        assertTrue(wardrobe.containsAll(secondSetOfGarments));
    }

    @Test
    public void mockProviderResponse() {
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment shirt = new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();

        Material trousersMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();

        Material shoesMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment shoes = new GarmentBuilder().setType(Type.SHOE).setMaterial(shoesMaterial).build();
        Set<Garment> garments = new HashSet<>(Arrays.asList(shirt, trousers, shoes));
        Wardrobe wardrobe = new Wardrobe(garments);
        WeatherProvider weatherProviderMock = mock(WeatherProvider.class);
        when(weatherProviderMock.getWeather("BsAs")).thenReturn(24.0);
        AttireGenerator generator = new AttireGenerator(weatherProviderMock);

        Set<Attire> attires = generator.getSuggestions(wardrobe);

        List<Attire> attiresList = Lists.newArrayList(attires);
        assertEquals(1, attiresList.size());
    }
}
