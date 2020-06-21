import builder.GarmentBuilder;
import com.google.common.collect.Lists;
import command.AddGarment;
import command.RemoveGarment;
import domain.*;
import exception.GarmentNotValidException;
import org.junit.Test;
import weather.WeatherProvider;
import java.awt.*;
import java.util.*;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuilderWardrobesTest {
    private static final String MAIL1 = "jc@gmail.com";
    private static final String MAIL2 = "jk@gmail.com";

    @Test
    public void buildGarment() {
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment garment = new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();

        assertEquals(Type.SHIRT, garment.getType());
        assertEquals(Cloth.COTTON, garment.getMaterial().getCloth());
        assertEquals(Plot.SMOOTH, garment.getMaterial().getPlot());
        assertTrue(garment.getMaterial().getColors().contains(Color.BLACK));
    }

    @Test(expected = GarmentNotValidException.class)
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
        Wardrobe wardrobe = this.getWardrobeByDefault();
        Material sneakersMaterial = new Material(Cloth.CANVAS, Collections.singletonList(Color.BLACK));
        Garment sneakers = new GarmentBuilder().setType(Type.SNEAKER).setMaterial(sneakersMaterial).build();
        wardrobe.addGarment(sneakers);
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
        Wardrobe wardrobe = this.getWardrobeByDefault();
        WeatherProvider weatherProviderMock = mock(WeatherProvider.class);
        when(weatherProviderMock.getWeather("BsAs")).thenReturn(24.0);
        AttireGenerator generator = new AttireGenerator(weatherProviderMock);

        Set<Attire> attires = generator.getSuggestions(wardrobe);

        List<Attire> attiresList = Lists.newArrayList(attires);
        assertEquals(1, attiresList.size());
    }

    @Test(expected = GarmentNotValidException.class)
    public void whenAddingIncompatibleWardrobeGarmentShouldThrowAnException() {
        Wardrobe wardrobe = new Wardrobe(Criteria.FORMAL_CLOTHES);
        Material trousersMaterial = new Material(Cloth.JEAN, Collections.singletonList(Color.BLUE));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();
        wardrobe.addGarment(trousers);
    }

    @Test
    public void whenSharingAWardrobeTheyShouldHaveTheSameWardrobe() {
        Wardrobe wardrobe = new Wardrobe(Criteria.INFORMAL_CLOTHES);
        Material trousersMaterial = new Material(Cloth.JEAN, Collections.singletonList(Color.BLUE));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();
        wardrobe.addGarment(trousers);
        User user = new User(MAIL1);
        user.addWardrobe(wardrobe);
        User otherUser = new User(MAIL2);

        wardrobe.shareWith(otherUser);

        assertEquals(otherUser.getWardrobes(), user.getWardrobes());
    }

    @Test
    public void whenAnAcceptedModificationIsRolledBackShouldRemoveGarments() {
        Wardrobe wardrobe = new Wardrobe(Criteria.INFORMAL_CLOTHES);
        Material trousersMaterial = new Material(Cloth.JEAN, Collections.singletonList(Color.BLUE));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();
        wardrobe.addGarment(trousers);
        User user = new User(MAIL1);
        user.addWardrobe(wardrobe);
        AddGarment addGarment = new AddGarment(wardrobe, trousers);
        RemoveGarment removeGarment = new RemoveGarment(wardrobe, trousers);
        user.addPendingModification(addGarment);
        user.addPendingModification(removeGarment);
        user.executeModification(addGarment);

        user.undoAcceptedModifications();

        assertTrue(wardrobe.getGarments().isEmpty());
    }

    private Wardrobe getWardrobeByDefault() {
        Material material = new Material(Cloth.COTTON, Collections.singletonList(Color.BLACK));
        Garment shirt = new GarmentBuilder().setType(Type.SHIRT).setMaterial(material).build();
        Material trousersMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment trousers = new GarmentBuilder().setType(Type.TROUSERS).setMaterial(trousersMaterial).build();
        Material shoesMaterial = new Material(Cloth.LEATHER, Collections.singletonList(Color.BLACK));
        Garment shoes = new GarmentBuilder().setType(Type.SHOE).setMaterial(shoesMaterial).build();
        Wardrobe wardrobe = new Wardrobe(Criteria.INFORMAL_CLOTHES);
        wardrobe.addGarment(shirt);
        wardrobe.addGarment(trousers);
        wardrobe.addGarment(shoes);

        return wardrobe;
    }
}
