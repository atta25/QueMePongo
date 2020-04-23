public enum Tipo {
    CAMISA(Categoria.SUPERIOR),
    REMERA(Categoria.SUPERIOR),
    CAMPERA(Categoria.SUPERIOR),
    CHOMBA(Categoria.SUPERIOR),
    PANTALON(Categoria.INFERIOR),
    ZAPATO(Categoria.CALZADO),
    ZAPATILLAS(Categoria.CALZADO);

    private Categoria categoria;

    Tipo(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }
}
