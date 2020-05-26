public class Pronostic {
    private WeatherProvider weatherProvider;

    public Pronostic(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public Double getTemperature(String city) {
        return weatherProvider.getWeather(city);
    }
}
