import java.awt.*;
import java.util.Collections;

public class SanJuan extends Institucion {
    @Override
    protected Prenda getPrendaSuperior() {
        PrendaBuilder prendaBuilderChomba = new PrendaBuilder();
        prendaBuilderChomba.setTipo(Tipo.CHOMBA);
        Material materialChomba = new Material();
        materialChomba.setColores(Collections.singletonList(Color.GREEN));
        materialChomba.setTela(Tela.PIQUE);
        prendaBuilderChomba.setMaterial(materialChomba);
        return prendaBuilderChomba.build();
    }

    @Override
    protected Prenda getPrendaInferior() {
        PrendaBuilder prendaBuilderPantalon = new PrendaBuilder();
        prendaBuilderPantalon.setTipo(Tipo.PANTALON);
        Material materialPantalon = new Material();
        materialPantalon.setColores(Collections.singletonList(Color.GRAY));
        materialPantalon.setTela(Tela.ACETATO);
        prendaBuilderPantalon.setMaterial(materialPantalon);
        return prendaBuilderPantalon.build();
    }

    @Override
    protected Prenda getCalzado() {
        PrendaBuilder prendaBuilderZapatillas = new PrendaBuilder();
        prendaBuilderZapatillas.setTipo(Tipo.ZAPATILLAS);
        Material materialZapatillas = new Material();
        materialZapatillas.setColores(Collections.singletonList(Color.WHITE));
        materialZapatillas.setTela(Tela.LONA);
        prendaBuilderZapatillas.setMaterial(materialZapatillas);
        return prendaBuilderZapatillas.build();
    }
}
