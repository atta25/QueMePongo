import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class AttireGenerator {
    public Set<Attire> getSuggestions(Set<Garment> garments, Double currentTemperature) {
        Predicate<Set<Garment>> doesNotRepeatGarmentTypes = garmentsSet -> {
            long quantityOfDifferentGarmentTypes = garmentsSet.stream().map(Garment::getType).distinct().count();
            return quantityOfDifferentGarmentTypes == garmentsSet.size();
        };

        Predicate<Set<Garment>> haveNecessaryClothes = garmentsSet -> {
            Set<Category> mandatoryCategories = new HashSet<>(Arrays.asList(Category.HIGHER, Category.LOWER, Category.FOOTWEAR));

            return garmentsSet.stream()
                              .map(garment -> garment.getType().getCategory())
                              .collect(Collectors.toList())
                              .containsAll(mandatoryCategories);
        };

        Predicate<Set<Garment>> doesNotRepeatGarmentCategories = garmentsSet -> garmentsSet.stream()
                                                                                           .collect(groupingBy(garment -> garment.getType().getCategory(), counting()))
                                                                                           .entrySet()
                                                                                           .stream()
                                                                                           .allMatch(map -> map.getValue() == 1);

        Predicate<Set<Garment>> isSuitable = garmentsSet -> garmentsSet.stream().map(Garment::getType).allMatch(type -> type.isSuitable(currentTemperature));

        Predicate<Set<Garment>> isValidAttire = doesNotRepeatGarmentTypes.and(haveNecessaryClothes).and(doesNotRepeatGarmentCategories).and(isSuitable);

        return Sets.powerSet(garments).stream().filter(isValidAttire).map(Attire::new).collect(Collectors.toSet());
    }
}
