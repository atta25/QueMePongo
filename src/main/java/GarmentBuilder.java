import exception.GarmentNotValidException;

public class GarmentBuilder {
    private Type type;
    private Material material;

    public GarmentBuilder setType(Type type) {
        this.type = type;
        return this;
    }

    public GarmentBuilder setMaterial(Material material) {
        this.material = material;
        return this;
    }

    public Garment build() {
        if (type == null) throw new GarmentNotValidException("The type of the garment was not specified");

        if (material.isValidFor(type)) {
            return new Garment(type, material);
        } else {
            throw new GarmentNotValidException("Type and fabric are inconsistent");
        }
    }
}
