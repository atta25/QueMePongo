package API;

import java.util.*;

public final class AccuWeatherAPI {
    public final List<Map<String, Object>> getWeather(String city) {
        return Arrays.asList(new HashMap(){{
            put("DateTime", "2019-05-03T01:00:00-03:00");
            put("EpochDateTime", 1556856000);
            put("WeatherIcon", 33);
            put("IconPhrase", "Clear");
            put("IsDaylight", false);
            put("PrecipitationProbability", 0);
            put("MobileLink", "http://m.accuweather.com/en/ar/villa-vil/7984/");
            put("Link", "http://www.accuweather.com/en/ar/villa-vil/7984");
            put("Temperature", new HashMap(){{
                put("Value", 57.0);
                put("Unit", "F");
                put("UnitType", 18);
            }});
        }});
    }

    public final Map<String, List<String>> getAlerts(String city) {
        return new HashMap<String, List<String>>() {{
                put("CurrentAlerts", Arrays.asList("STORM", "HAIL"));}};
     }
}
