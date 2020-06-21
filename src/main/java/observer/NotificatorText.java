package observer;

import domain.User;
import service.NotificationService;
import weather.WeatherProvider;
import java.util.List;

public class NotificatorText extends Notificator {
    private NotificationService notificationService;

    public NotificatorText(WeatherProvider weatherProvider, Recommendation recommendation, NotificationService notificationService) {
        super(weatherProvider, recommendation);
        this.notificationService = notificationService;
    }

    @Override
    public void weatherAlertGenerated(User user, List<String> alerts) {
        notificationService.notify(this.getMessage(alerts));
    }
}
