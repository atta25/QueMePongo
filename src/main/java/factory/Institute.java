package factory;

import domain.Garment;
import domain.Uniform;

public abstract class Institute {
    public Uniform getUniform() {
        return new Uniform(this.getUpperGarment(),
                           this.getLowerGarment(),
                           this.getFootwear());
    }

    protected abstract Garment getUpperGarment();
    protected abstract Garment getLowerGarment();
    protected abstract Garment getFootwear();
}
