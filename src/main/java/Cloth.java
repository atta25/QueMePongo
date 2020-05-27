import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Cloth {
    COTTON(Collections.singletonList(Type.SHIRT)),
    LEATHER(Arrays.asList(Type.JACKET, Type.SHOE, Type.TROUSERS)),
    SILK(Arrays.asList(Type.SHIRT, Type.TSHIRT)),
    PIQUE(Collections.singletonList(Type.CHOMBA)),
    CANVAS(Collections.singletonList(Type.SNEAKER)),
    ACETATE(Collections.singletonList(Type.TROUSERS));

    private final List<Type> supportedTypes;

    Cloth(List<Type> supportedTypes) {
        this.supportedTypes = supportedTypes;
    }

    public boolean isConsistentFor(Type type) {
        return this.supportedTypes.contains(type);
    }
}
