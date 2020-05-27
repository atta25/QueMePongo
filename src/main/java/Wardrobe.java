import java.util.Set;

public class Wardrobe {
    private Set<Garment> garments;

    public Wardrobe(Set<Garment> garments) {
        this.garments = garments;
    }

    public Set<Garment> getGarments() {
        return garments;
    }

    public Boolean containsAll(Set<Garment> garments) {
        return this.garments.containsAll(garments);
    }
}
