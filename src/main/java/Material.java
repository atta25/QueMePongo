import java.util.List;
import java.awt.*;

public class Material {
    private List<Color> colors;
    private Cloth cloth;
    private Plot plot;

    public Material() {
       plot = Plot.SMOOTH;
    }

    public boolean isValidFor(Type type) {
        return cloth.isConsistentFor(type);
    }

    public List<Color> getColors() {
        return colors;
    }

    public Cloth getCloth() {
        return cloth;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public void setCloth(Cloth cloth) {
        this.cloth = cloth;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }
}
