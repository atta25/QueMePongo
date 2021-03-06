package command;

import domain.Garment;
import domain.User;
import domain.Wardrobe;

public class AddGarment implements Modification {
    private Wardrobe wardrobe;
    private Garment garment;

    public AddGarment(Wardrobe wardrobe, Garment garment) {
        this.wardrobe = wardrobe;
        this.garment = garment;
    }

    @Override
    public void apply(User user) {
        user.addGarmentToWardrobe(wardrobe, garment);
    }

    @Override
    public void undo(User user) {
        user.removeGarmentToWardrobe(wardrobe, garment);
    }

    public RemoveGarment convertToRemoveGarment() {
        return new RemoveGarment(wardrobe, garment);
    }
}
