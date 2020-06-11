import API.AccuWeatherAPI;
import java.util.List;
import java.util.Map;

public class AccuProvider implements WeatherProvider {
    @Override
    public Double getWeather(String city) {
        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();
        Map<String, Object> map = (Map<String, Object>) accuWeatherAPI.getWeather(city).get(0).get("Temperature");
        return convertFahrenheitToCelsius((Double) map.get("Value"));
    }

    @Override
    public List<String> getCurrentAlerts(String city) {
        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();
        return accuWeatherAPI.getAlerts(city).get("CurrentAlerts");
    }

    private Double convertFahrenheitToCelsius(Double degreesFahrenheit) {
        return (degreesFahrenheit - 32) * 5/9;
    }
}
