import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SanJuan implements Institucion {
    @Override
    public List<Prenda> getPrendas() {
        PrendaBuilder prendaBuilderChomba = new PrendaBuilder();
        prendaBuilderChomba.setTipo(Tipo.CHOMBA);
        Material materialChomba = new Material();
        materialChomba.setColores(Collections.singletonList(Color.GREEN));
        materialChomba.setTela(Tela.PIQUE);
        prendaBuilderChomba.setMaterial(materialChomba);
        Prenda chomba = prendaBuilderChomba.build();

        PrendaBuilder prendaBuilderPantalon = new PrendaBuilder();
        prendaBuilderPantalon.setTipo(Tipo.PANTALON);
        Material materialPantalon = new Material();
        materialPantalon.setColores(Collections.singletonList(Color.GRAY));
        materialPantalon.setTela(Tela.ACETATO);
        prendaBuilderPantalon.setMaterial(materialPantalon);
        Prenda pantalon = prendaBuilderPantalon.build();

        PrendaBuilder prendaBuilderZapatillas = new PrendaBuilder();
        prendaBuilderZapatillas.setTipo(Tipo.ZAPATILLAS);
        Material materialZapatillas = new Material();
        materialZapatillas.setColores(Collections.singletonList(Color.WHITE));
        materialZapatillas.setTela(Tela.LONA);
        prendaBuilderZapatillas.setMaterial(materialPantalon);
        Prenda zapatillas = prendaBuilderZapatillas.build();

        return Arrays.asList(chomba, pantalon, zapatillas);
    }
}
