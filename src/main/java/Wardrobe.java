import exception.GarmentNotValidException;
import java.util.HashSet;
import java.util.Set;

public class Wardrobe {
    private Criteria criteria;
    private Set<Garment> garments;

    public Wardrobe(Criteria criteria) {
        this.criteria = criteria;
        this.garments = new HashSet<>();
    }

    public void addGarment(Garment garment) {
        if (garment.getMaterial().getCloth().isConsistentForTheCriteria(criteria)) {
            garments.add(garment);
        } else {
            throw new GarmentNotValidException("This garment is not valid for this wardrobe");
        }
    }

    public void removeGarment(Garment garment) {
        garments.remove(garment);
    }

    public void shareWith(User user) {
        user.addWardrobe(this);
    }

    public Set<Garment> getGarments() {
        return garments;
    }

    public Boolean containsAll(Set<Garment> garments) {
        return this.garments.containsAll(garments);
    }
}
