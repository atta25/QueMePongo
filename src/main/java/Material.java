import java.util.List;
import java.awt.*;

public class Material {
    private List<Color> colores;
    private Tela tela;
    private Trama trama;

    public Material() {
       trama = Trama.LISO;
    }

    public boolean esValidoPara(Tipo tipo) {
        return tela.esConsistentePara(tipo);
    }

    public List<Color> getColores() {
        return colores;
    }

    public Tela getTela() {
        return tela;
    }

    public Trama getTrama() {
        return trama;
    }

    public void setColores(List<Color> colores) {
        this.colores = colores;
    }

    public void setTela(Tela tela) {
        this.tela = tela;
    }

    public void setTrama(Trama trama) {
        this.trama = trama;
    }
}
