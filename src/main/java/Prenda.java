import java.awt.*;
import java.util.Objects;

public class Prenda {
    private Tipo tipo;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;

    public Tipo getTipo() {
        return tipo;
    }

    public Prenda(Tipo tipo, Material material, Color colorPrincipal) {
        this.tipo = Objects.requireNonNull(tipo, "El tipo es nulo");
        this.material = Objects.requireNonNull(material, "El material es nulo");
        this.colorPrincipal = Objects.requireNonNull(colorPrincipal, "El color principal es nulo");
    }

    public Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario) {
        this(tipo, material, colorPrincipal);
        this.colorSecundario = colorSecundario;
        this.validarColores(colorPrincipal, colorSecundario);
    }

    private void validarColores(Color colorPrincipal, Color colorSecundario) {
        if (colorPrincipal.equals(colorSecundario)) {
            throw new DuplicatedColorsException();
        }
    }
}
