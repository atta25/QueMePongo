import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Cloth {
    COTTON {
        @Override
        public boolean isConsistentFor(Type type) {
            List<Type> compatibleGarmentTypes = Collections.singletonList(Type.SHIRT);
            return this.containsType(compatibleGarmentTypes, type);
        }
    },

    LEATHER {
        @Override
        public boolean isConsistentFor(Type type) {
            List<Type> compatibleGarmentTypes = Arrays.asList(Type.JACKET, Type.SHOE, Type.TROUSER);
            return this.containsType(compatibleGarmentTypes, type);
        }
    },

    SILK {
        @Override
        public boolean isConsistentFor(Type type) {
            List<Type> compatibleGarmentTypes = Arrays.asList(Type.SHIRT, Type.TSHIRT);
            return this.containsType(compatibleGarmentTypes, type);
        }
    },

    PIQUE {
        @Override
        public boolean isConsistentFor(Type type) {
            List<Type> compatibleGarmentTypes = Collections.singletonList(Type.CHOMBA);
            return this.containsType(compatibleGarmentTypes, type);
        }
    },

    CANVAS {
        @Override
        public boolean isConsistentFor(Type type) {
            List<Type> compatibleGarmentTypes = Collections.singletonList(Type.SNEAKER);
            return this.containsType(compatibleGarmentTypes, type);
        }
    },

    ACETATE {
        @Override
        public boolean isConsistentFor(Type type) {
            List<Type> compatibleGarmentTypes = Collections.singletonList(Type.TROUSER);
            return this.containsType(compatibleGarmentTypes, type);
        }
    };

    public abstract boolean isConsistentFor(Type type);

    protected Boolean containsType(List<Type> types, Type type) {
        return types.contains(type);
    }
}
