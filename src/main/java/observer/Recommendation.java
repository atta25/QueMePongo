package observer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recommendation {
    private static final Map<String, String> recommendationsMap = new HashMap(){{put("STORM", "carry umbrella");
                                                                                 put("HAIL", "avoid going out without a car");}};

    public String getMessage(List<String> weatherConditions) {
        return weatherConditions.stream().map(recommendationsMap::get).collect(Collectors.joining(", "));
    }
}
