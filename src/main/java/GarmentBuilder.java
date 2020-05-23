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
        if (type == null) throw new BuildGarmentException("El tipo de la prenda no fue especificado");

        if (material.isValidFor(type)) {
            return new Garment(type, material);
        } else {
            throw new BuildGarmentException("El tipo y la tela son inconsistentes");
        }
    }
}
