import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class AttireGenerator {
    private WeatherProvider weatherProvider;

    public AttireGenerator(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public Set<Attire> getSuggestions(Wardrobe wardrobe) {
        Double currentTemperature = weatherProvider.getWeather("BsAs");
        return Sets.powerSet(wardrobe.getGarments()).stream().filter(garments -> isValidAttire(garments, currentTemperature)).map(Attire::new).collect(Collectors.toSet());
    }

    private Boolean isValidAttire(Set<Garment> garments, Double currentTemperature) {
        return doesNotRepeatGarmentTypes(garments) &&
                haveNecessaryClothes(garments) &&
                doesNotRepeatGarmentCategories(garments) &&
                isSuitable(garments, currentTemperature);
    }

    private Boolean doesNotRepeatGarmentTypes(Set<Garment> garments) {
        long quantityOfDifferentGarmentTypes = garments.stream().map(Garment::getType).distinct().count();
        return quantityOfDifferentGarmentTypes == garments.size();
    }

    private Boolean haveNecessaryClothes(Set<Garment> garments) {
        Set<Category> mandatoryCategories = new HashSet<>(Arrays.asList(Category.HIGHER, Category.LOWER, Category.FOOTWEAR));
        return garments.stream()
                .map(garment -> garment.getType().getCategory())
                .collect(Collectors.toList())
                .containsAll(mandatoryCategories);
    }

    private Boolean doesNotRepeatGarmentCategories(Set<Garment> garments) {
        return garments.stream()
                .collect(groupingBy(garment -> garment.getType().getCategory(), counting()))
                .entrySet()
                .stream()
                .allMatch(map -> map.getValue() == 1);
    }

    private Boolean isSuitable(Set<Garment> garments, Double currentTemperature) {
        return garments.stream().map(Garment::getType).allMatch(type -> type.isSuitable(currentTemperature));
    }
}
