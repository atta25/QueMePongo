import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Cloth {
    COTTON(new HashSet<>(Collections.singleton(Type.SHIRT)),
            new HashSet<>(Arrays.asList(Criteria.FORMAL_CLOTHES, Criteria.INFORMAL_CLOTHES))),
    LEATHER(new HashSet<>(Arrays.asList(Type.JACKET, Type.SHOE, Type.TROUSERS)),
            new HashSet<>(Collections.singletonList(Criteria.INFORMAL_CLOTHES))),
    SILK(new HashSet<>(Arrays.asList(Type.SHIRT, Type.TSHIRT)),
            new HashSet<>(Arrays.asList(Criteria.FORMAL_CLOTHES, Criteria.INFORMAL_CLOTHES))),
    PIQUE(new HashSet<>(Collections.singleton(Type.CHOMBA)),
            new HashSet<>(Arrays.asList(Criteria.FORMAL_CLOTHES, Criteria.INFORMAL_CLOTHES))),
    CANVAS(new HashSet<>(Collections.singleton(Type.SNEAKER)),
            new HashSet<>(Collections.singletonList(Criteria.INFORMAL_CLOTHES))),
    ACETATE(new HashSet<>(Collections.singleton(Type.TROUSERS)),
            new HashSet<>(Collections.singletonList(Criteria.INFORMAL_CLOTHES))),
    JEAN(new HashSet<>(Arrays.asList(Type.SHIRT, Type.TROUSERS)),
            new HashSet<>(Collections.singletonList(Criteria.INFORMAL_CLOTHES)));

    private final Set<Type> supportedTypes;
    private final Set<Criteria> supportedCriteria;

    Cloth(Set<Type> supportedTypes, Set<Criteria> supportedCriteria) {
        this.supportedTypes = supportedTypes;
        this.supportedCriteria = supportedCriteria;
    }

    public boolean isConsistentForTheType(Type type) {
        return this.supportedTypes.contains(type);
    }

    public boolean isConsistentForTheCriteria(Criteria criteria) {
        return this.supportedCriteria.contains(criteria);
    }
}
