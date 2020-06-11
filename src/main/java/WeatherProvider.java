import java.util.List;

public interface WeatherProvider {
    Double getWeather(String city);
    List<String> getCurrentAlerts(String city);
}
