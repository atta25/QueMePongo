package observer;

import domain.User;
import service.MailSender;
import weather.WeatherProvider;
import java.util.List;

public class NotificatorMail extends Notificator {
    private MailSender mailSender;

    public NotificatorMail(WeatherProvider weatherProvider, Recommendation recommendation, MailSender mailSender) {
        super(weatherProvider, recommendation);
        this.mailSender = mailSender;
    }

    @Override
    public void weatherAlertGenerated(User user, List<String> alerts) {
        mailSender.send(user.getEmailAddress(), this.getMessage(alerts));
    }
}
