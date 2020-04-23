import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Johnson implements Institucion {
    @Override
    public List<Prenda> getPrendas() {
        PrendaBuilder prendaBuilderCamisa = new PrendaBuilder();
        prendaBuilderCamisa.setTipo(Tipo.CAMISA);
        Material materialCamisa = new Material();
        materialCamisa.setColores(Collections.singletonList(Color.WHITE));
        materialCamisa.setTela(Tela.ALGODON);
        prendaBuilderCamisa.setMaterial(materialCamisa);
        Prenda camisa = prendaBuilderCamisa.build();

        PrendaBuilder prendaBuilderPantalon = new PrendaBuilder();
        prendaBuilderPantalon.setTipo(Tipo.PANTALON);
        Material materialPantalon = new Material();
        materialPantalon.setColores(Collections.singletonList(Color.BLACK));
        materialPantalon.setTela(Tela.SEDA);
        prendaBuilderPantalon.setMaterial(materialPantalon);
        Prenda pantalon = prendaBuilderPantalon.build();

        PrendaBuilder prendaBuilderZapatos = new PrendaBuilder();
        prendaBuilderZapatos.setTipo(Tipo.ZAPATO);
        Material materialZapatos = new Material();
        materialZapatos.setColores(Collections.singletonList(Color.BLACK));
        materialZapatos.setTela(Tela.CUERO);
        prendaBuilderZapatos.setMaterial(materialPantalon);
        Prenda zapatos = prendaBuilderZapatos.build();

        return Arrays.asList(camisa, pantalon, zapatos);
    }
}
