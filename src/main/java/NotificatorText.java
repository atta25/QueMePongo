import service.NotificationService;

public class NotificatorText extends Notificator {
    private NotificationService notificationService;

    public NotificatorText(WeatherProvider weatherProvider, Recommendation recommendation, NotificationService notificationService) {
        super(weatherProvider, recommendation);
        this.notificationService = notificationService;
    }

    @Override
    public void weatherAlertGenerated(User user) {
        notificationService.notify(this.getMessage());
    }
}
