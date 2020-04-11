import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.awt.*;

public class Tests {
    @Test
    public void tipoYCategoriaDeberianSerCompatibles() {
        Prenda prenda = new Prenda(Tipo.CAMISA, Material.SEDA, Color.BLUE);
        assertEquals(Categoria.SUPERIOR, prenda.getTipo().getCategoria());
    }

    @Test(expected = DuplicatedColorsException.class)
    public void cuandoSonElMismoColorDeberiaLanzarUnaExcepcion() {
        new Prenda(Tipo.PANTALON, Material.CUERO, Color.BLACK, Color.BLACK);
    }
}
