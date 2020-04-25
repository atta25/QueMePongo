import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Uniforme {
    private Prenda prendaSuperior;
    private Prenda prendaInferior;
    private Prenda calzado;
    private static Set<Categoria> categoriasObligatorias = new HashSet<>(Arrays.asList(Categoria.SUPERIOR, Categoria.INFERIOR, Categoria.CALZADO));

    public Uniforme(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
        this.prendaSuperior = prendaSuperior;
        this.prendaInferior = prendaInferior;
        this.calzado = calzado;
        this.validarCategorias(Arrays.asList(prendaSuperior, prendaInferior, calzado));
    }

    private void validarCategorias(List<Prenda> prendas) {
        Set<Categoria> categorias =  prendas.stream().map(prenda -> prenda.getTipo().getCategoria()).collect(Collectors.toSet());

        if (categorias.size() != 3 && categoriasObligatorias.containsAll(categorias)) {
            throw new BuildUniformeException();
        }
    }

    public Prenda getPrendaSuperior() {
        return prendaSuperior;
    }

    public Prenda getPrendaInferior() {
        return prendaInferior;
    }

    public Prenda getCalzado() {
        return calzado;
    }
}
