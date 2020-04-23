
public class Prenda {
    private Tipo tipo;
    private Material material;

    public Prenda(Tipo tipo, Material material) {
        this.tipo = tipo;
        this.material= material;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Material getMaterial() {
        return material;
    }
}
