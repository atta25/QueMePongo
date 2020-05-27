
public class Uniform {
    private Garment upperGarment;
    private Garment lowerGarment;
    private Garment footwear;

    public Uniform(Garment upperGarment, Garment lowerGarment, Garment footwear) {
        this.upperGarment = upperGarment;
        this.lowerGarment = lowerGarment;
        this.footwear = footwear;
    }

    public Garment getUpperGarment() {
        return upperGarment;
    }

    public Garment getLowerGarment() {
        return lowerGarment;
    }

    public Garment getFootwear() {
        return footwear;
    }
}
