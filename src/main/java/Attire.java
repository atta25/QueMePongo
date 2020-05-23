import java.util.Set;

public class Attire {
    private Set<Garment> garments;

    public Attire(Set<Garment> garments) {
        this.garments = garments;
    }

    public Set<Garment> getGarments() {
        return garments;
    }
}
