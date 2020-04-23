import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Uniforme {
    private List<Prenda> prendas;
    private static Set<Categoria> categoriasObligatorias = new HashSet<>(Arrays.asList(Categoria.SUPERIOR, Categoria.INFERIOR, Categoria.CALZADO));

    public Uniforme(List<Prenda> prendas) {
        this.prendas = prendas;
        this.validarCategorias(prendas);
    }

    private void validarCategorias(List<Prenda> prendas) {
        Set<Categoria> categorias =  prendas.stream().map(prenda -> prenda.getTipo().getCategoria()).collect(Collectors.toSet());

        if (categorias.size() != 3 && categoriasObligatorias.containsAll(categorias)) {
            throw new BuildUniformeException();
        }
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }
}
