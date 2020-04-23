import java.util.List;

public class Usuario {
    private List<Sugerencia> sugerencias;

    public void sugerir(List<Sugerencia> sugerencias) {
        this.sugerencias = sugerencias;
    }
}
