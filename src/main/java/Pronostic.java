public class Pronostic {
    private WeatherProviderAdapter weatherProviderAdapter;

    public Pronostic(WeatherProviderAdapter weatherProviderAdapter) {
        this.weatherProviderAdapter = weatherProviderAdapter;
    }

    public Double getTemperature(String city) {
        return weatherProviderAdapter.getWeather(city);
    }
}
