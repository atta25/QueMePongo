package factory;

import domain.Uniform;

public class UniformFactory {
    public static Uniform getUniform(Institute institute) {
        return institute.getUniform();
    }
}
