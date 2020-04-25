import org.junit.Test;
import java.awt.*;
import java.util.Collections;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void buildPrenda() {
        PrendaBuilder prendaBuilder = new PrendaBuilder();
        prendaBuilder.setTipo(Tipo.CAMISA);
        Material material = new Material();
        material.setColores(Collections.singletonList(Color.BLACK));
        material.setTela(Tela.ALGODON);
        prendaBuilder.setMaterial(material);
        Prenda prenda = prendaBuilder.build();

        assertEquals(Tipo.CAMISA, prenda.getTipo());
        assertTrue(prenda.getMaterial().getColores().containsAll(Collections.singletonList(Color.BLACK)));
        assertEquals(Tela.ALGODON, prenda.getMaterial().getTela());
        assertEquals(Trama.LISO , prenda.getMaterial().getTrama());
    }

    @Test(expected = BuildPrendaException.class)
    public void cuandoElTipoYTelaSonInconsistentesDeberiaLanzarUnaException() {
        PrendaBuilder prendaBuilder = new PrendaBuilder();
        prendaBuilder.setTipo(Tipo.CAMISA);
        Material material = new Material();
        material.setColores(Collections.singletonList(Color.BLACK));
        material.setTela(Tela.CUERO);
        material.setTrama(Trama.LISO);
        prendaBuilder.setMaterial(material);
        prendaBuilder.build();
    }

    @Test
    public void cuandoSeEspecificaElTipoLuegoDeberiaPoderEspecificarElMaterial() {
        PrendaBuilder prendaBuilder = new PrendaBuilder();
        prendaBuilder.setTipo(Tipo.CAMPERA);
        PrendaBuilder clone = prendaBuilder.clone();
        Material material = new Material();
        material.setColores(Collections.singletonList(Color.BLACK));
        material.setTela(Tela.CUERO);
        material.setTrama(Trama.LISO);
        clone.setMaterial(material);
        Prenda prenda = clone.build();

        assertEquals(Tipo.CAMPERA, prenda.getTipo());
        assertTrue(prenda.getMaterial().getColores().containsAll(Collections.singletonList(Color.BLACK)));
        assertEquals(Tela.CUERO, prenda.getMaterial().getTela());
        assertEquals(Trama.LISO , prenda.getMaterial().getTrama());
    }

    @Test
    public void buildUniforme() {
        PrendaBuilder prendaBuilderCamisa = new PrendaBuilder();
        prendaBuilderCamisa.setTipo(Tipo.CAMISA);
        Material materialCamisa = new Material();
        materialCamisa.setColores(Collections.singletonList(Color.BLACK));
        materialCamisa.setTela(Tela.ALGODON);
        prendaBuilderCamisa.setMaterial(materialCamisa);
        Prenda camisa = prendaBuilderCamisa.build();

        PrendaBuilder prendaBuilderPantalon = new PrendaBuilder();
        prendaBuilderPantalon.setTipo(Tipo.PANTALON);
        Material materialPantalon = new Material();
        materialPantalon.setColores(Collections.singletonList(Color.BLACK));
        materialPantalon.setTela(Tela.CUERO);
        prendaBuilderPantalon.setMaterial(materialPantalon);
        Prenda pantalon = prendaBuilderPantalon.build();

        PrendaBuilder prendaBuilderZapatos = new PrendaBuilder();
        prendaBuilderZapatos.setTipo(Tipo.ZAPATO);
        Material materialZapatos = new Material();
        materialZapatos.setColores(Collections.singletonList(Color.BLACK));
        materialZapatos.setTela(Tela.CUERO);
        prendaBuilderZapatos.setMaterial(materialZapatos);
        Prenda zapatos = prendaBuilderZapatos.build();

        Uniforme uniforme = new Uniforme(camisa, pantalon, zapatos);
        assertEquals(camisa, uniforme.getPrendaSuperior());
        assertEquals(pantalon, uniforme.getPrendaInferior());
        assertEquals(zapatos, uniforme.getCalzado());
    }

    @Test(expected = BuildUniformeException.class)
    public void cuandoElUniformeNoTieneLasCategoriasObligatoriasDeberiaLanzarUnaException() {
        PrendaBuilder prendaBuilderCamisa = new PrendaBuilder();
        prendaBuilderCamisa.setTipo(Tipo.CAMISA);
        Material materialCamisa = new Material();
        materialCamisa.setColores(Collections.singletonList(Color.BLACK));
        materialCamisa.setTela(Tela.ALGODON);
        prendaBuilderCamisa.setMaterial(materialCamisa);
        Prenda camisa = prendaBuilderCamisa.build();

        PrendaBuilder prendaBuilderPantalon = new PrendaBuilder();
        prendaBuilderPantalon.setTipo(Tipo.PANTALON);
        Material materialPantalon = new Material();
        materialPantalon.setColores(Collections.singletonList(Color.BLACK));
        materialPantalon.setTela(Tela.CUERO);
        prendaBuilderPantalon.setMaterial(materialPantalon);
        Prenda pantalon = prendaBuilderPantalon.build();

        new Uniforme(camisa, camisa, pantalon);
    }
}
