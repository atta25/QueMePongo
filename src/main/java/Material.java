import java.util.List;
import java.awt.*;

public class Material {
    private Cloth cloth;
    private Plot plot;
    private List<Color> colors;

    public Material(Cloth cloth, Plot plot, List<Color> colors) {
        this.cloth = cloth;
        this.plot = plot;
        this.colors = colors;
    }

    public Material(Cloth cloth, List<Color> colors) {
        this(cloth, Plot.SMOOTH, colors);
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
