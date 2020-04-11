public enum Tipo {
    ZAPATO(Categoria.CALZADO),
    CAMISA(Categoria.SUPERIOR),
    PANTALON(Categoria.INFERIOR);

    private Categoria categoria;

    Tipo(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
}
