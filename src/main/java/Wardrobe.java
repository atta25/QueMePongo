import java.util.Set;

public class Wardrobe {
    private Set<Garment> garments;

    public Wardrobe(Set<Garment> garments) {
        this.garments = garments;
    }

    public Set<Garment> getGarments() {
        return garments;
    }
}
