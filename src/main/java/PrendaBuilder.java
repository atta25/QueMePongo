public class PrendaBuilder implements Cloneable {
    private Tipo tipo;
    private Material material;

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Prenda build() {
        if (tipo == null) throw new BuildPrendaException("El tipo de la prenda no fue especificado");

        if (material.esValidoPara(tipo)) {
            return new Prenda(tipo, material);
        } else {
            throw new BuildPrendaException("El tipo y la tela son inconsistentes");
        }
    }

    public PrendaBuilder clone() {
        PrendaBuilder result = new PrendaBuilder();
        result.tipo = this.tipo;
        result.material = this.material;

        return result;
    }
}
