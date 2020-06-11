import java.util.List;

public abstract class Notificator implements Observer {
    protected WeatherProvider weatherProvider;
    protected Recommendation recommendation;

    Notificator(WeatherProvider weatherProvider, Recommendation recommendation) {
        this.weatherProvider = weatherProvider;
        this.recommendation = recommendation;
    }

    public String getMessage() {
        List<String> currentAlerts = weatherProvider.getCurrentAlerts("BsAs");
        return recommendation.getMessage(currentAlerts);
    }
}
