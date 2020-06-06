import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private Set<Wardrobe> wardrobes;
    private List<Modification> pendingModifications;
    private List<Modification> executeModifications;

    public User() {
        this.wardrobes = new HashSet<>();
        this.pendingModifications = new ArrayList<>();
        this.executeModifications = new ArrayList<>();
    }

    public Set<Wardrobe> getWardrobes() {
        return wardrobes;
    }

    public void addWardrobe(Wardrobe wardrobe) {
        wardrobes.add(wardrobe);
    }

    public void addPendingModification(Modification modification) {
        pendingModifications.add(modification);
    }

    public void removePendingModification(Modification modification) {
        pendingModifications.remove(modification);
    }

    public void executeModification(Modification modification) {
        modification.apply(this);
        pendingModifications.remove(modification);
        executeModifications.add(modification);
    }

    public void addGarmentToWardrobe(Wardrobe wardrobe, Garment garment) {
        wardrobe.addGarment(garment);
    }

    public void removeGarmentToWardrobe(Wardrobe wardrobe, Garment garment) {
        wardrobe.removeGarment(garment);
    }

    public void undoAcceptedModifications() {
        executeModifications.forEach(executeModification -> executeModification.undo(this));
        executeModifications.clear();
    }
}
