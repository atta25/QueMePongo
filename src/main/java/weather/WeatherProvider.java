package weather;

import java.util.List;
import java.util.Map;

public interface WeatherProvider {
    Double getWeather(String city);
    Map<String, List<String>> getCurrentAlerts(String city);
}
