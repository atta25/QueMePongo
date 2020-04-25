import java.awt.*;
import java.util.Collections;

public class Johnson extends Institucion {
    @Override
    protected Prenda getPrendaSuperior() {
        PrendaBuilder prendaBuilderCamisa = new PrendaBuilder();
        prendaBuilderCamisa.setTipo(Tipo.CAMISA);
        Material materialCamisa = new Material();
        materialCamisa.setColores(Collections.singletonList(Color.WHITE));
        materialCamisa.setTela(Tela.ALGODON);
        prendaBuilderCamisa.setMaterial(materialCamisa);
        return prendaBuilderCamisa.build();
    }

    @Override
    protected Prenda getPrendaInferior() {
        PrendaBuilder prendaBuilderPantalon = new PrendaBuilder();
        prendaBuilderPantalon.setTipo(Tipo.PANTALON);
        Material materialPantalon = new Material();
        materialPantalon.setColores(Collections.singletonList(Color.BLACK));
        materialPantalon.setTela(Tela.SEDA);
        prendaBuilderPantalon.setMaterial(materialPantalon);
        return prendaBuilderPantalon.build();
    }

    @Override
    protected Prenda getCalzado() {
        PrendaBuilder prendaBuilderZapatos = new PrendaBuilder();
        prendaBuilderZapatos.setTipo(Tipo.ZAPATO);
        Material materialZapatos = new Material();
        materialZapatos.setColores(Collections.singletonList(Color.BLACK));
        materialZapatos.setTela(Tela.CUERO);
        prendaBuilderZapatos.setMaterial(materialZapatos);
        return prendaBuilderZapatos.build();
    }
}
