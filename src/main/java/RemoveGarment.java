public class RemoveGarment implements Modification {
    private Wardrobe wardrobe;
    private Garment garment;

    public RemoveGarment(Wardrobe wardrobe, Garment garment) {
        this.wardrobe = wardrobe;
        this.garment = garment;
    }

    @Override
    public void apply(User user) {
        user.removeGarmentToWardrobe(wardrobe, garment);
    }

    @Override
    public void undo(User user) {
        user.addGarmentToWardrobe(wardrobe, garment);
    }
}
