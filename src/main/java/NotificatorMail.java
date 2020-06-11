import service.MailSender;

public class NotificatorMail extends Notificator {
    private MailSender mailSender;

    public NotificatorMail(WeatherProvider weatherProvider, Recommendation recommendation, MailSender mailSender) {
        super(weatherProvider, recommendation);
        this.mailSender = mailSender;
    }

    @Override
    public void weatherAlertGenerated(User user) {
        mailSender.send(user.getEmailAddress(), this.getMessage());
    }
}
