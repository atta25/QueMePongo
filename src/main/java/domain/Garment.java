package domain;

public class Garment {
    private Type type;
    private Material material;

    public Garment(Type type, Material material) {
        this.type = type;
        this.material= material;
    }

    public Type getType() {
        return type;
    }

    public Material getMaterial() {
        return material;
    }
}
