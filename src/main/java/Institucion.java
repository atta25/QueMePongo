
public abstract class Institucion {
    public Uniforme getUniforme() {
        return new Uniforme(this.getPrendaSuperior(),
                            this.getPrendaInferior(),
                            this.getCalzado());
    }

    protected abstract Prenda getPrendaSuperior();
    protected abstract Prenda getPrendaInferior();
    protected abstract Prenda getCalzado();
}
