import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Uniform {
    private Garment upperGarment;
    private Garment lowerGarment;
    private Garment footwear;
    private static Set<Category> mandatoryCategories = new HashSet<>(Arrays.asList(Category.HIGHER, Category.LOWER, Category.FOOTWEAR));

    public Uniform(Garment upperGarment, Garment lowerGarment, Garment footwear) {
        this.upperGarment = upperGarment;
        this.lowerGarment = lowerGarment;
        this.footwear = footwear;
        this.validateCategories(Arrays.asList(upperGarment, lowerGarment, footwear));
    }

    private void validateCategories(List<Garment> garments) {
        Set<Category> categories =  garments.stream().map(garment -> garment.getType().getCategory()).collect(Collectors.toSet());

        if (categories.size() != 3 && mandatoryCategories.containsAll(categories)) {
            throw new BuildUniformException();
        }
    }

    public Garment getUpperGarment() {
        return upperGarment;
    }

    public Garment getLowerGarment() {
        return lowerGarment;
    }

    public Garment getFootwear() {
        return footwear;
    }
}
