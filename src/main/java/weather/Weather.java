package weather;

import repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    private WeatherProvider weatherProvider;
    private List<String> currentAlerts;

    public Weather(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
        this.currentAlerts = new ArrayList<>();
    }

    public void updateAlerts(String city) {
        currentAlerts = weatherProvider.getCurrentAlerts(city).get("CurrentAlerts");
        UserRepository.getInstance().getUsers().forEach(user -> user.weatherAlertWasGenerated(currentAlerts));
    }

    public List<String> showCurrentAlerts() {
        return currentAlerts;
    }
}
