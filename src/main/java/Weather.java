import java.util.ArrayList;
import java.util.List;

public class Weather {
    private WeatherProvider weatherProvider;
    private List<String> currentAlerts;

    public Weather(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
        this.currentAlerts = new ArrayList<>();
    }

    public void updateAlerts() {
        currentAlerts = weatherProvider.getCurrentAlerts("BsAs");
    }
}
