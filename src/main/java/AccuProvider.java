import API.AccuWeatherAPI;
import java.util.Map;

public class AccuProvider implements WeatherProvider {
    @Override
    public Double getWeather(String city) {
        AccuWeatherAPI accuWeatherAPI = new AccuWeatherAPI();
        Map<String, Object> map = (Map<String, Object>) accuWeatherAPI.getWeather(city).get(0).get("Temperature");
        return convertFahrenheitToCelcius((Double) map.get("Value"));
    }

    private Double convertFahrenheitToCelcius(Double degreesFahrenheit) {
        return (degreesFahrenheit - 32) * 5/9;
    }
}
