import domain.User;
import observer.NotificatorMail;
import observer.NotificatorText;
import observer.Recommendation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import repository.UserRepository;
import service.MailSender;
import service.NotificationService;
import weather.AccuProvider;
import weather.Weather;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherAlertGeneratedTest {
    @Mock
    private Recommendation recommendation;
    @Mock
    private NotificationService notificationService;
    @Mock
    private MailSender mailSender;
    @InjectMocks
    private NotificatorText notificatorText;
    @InjectMocks
    private NotificatorMail notificatorMail;
    private User user;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        user = new User("jk@gmail.com");
    }

    @Test
    public void executeObserversWhenWeatherAlertWasGenerated() {
        UserRepository userRepository = UserRepository.getInstance();
        userRepository.addUser(user);
        user.addObserver(notificatorText);
        user.addObserver(notificatorMail);

        Weather weather = new Weather(new AccuProvider());
        weather.updateAlerts("BsAs");

        verify(notificationService, times(1)).notify(anyString());
        verify(mailSender, times(1)).send(anyString(), anyString());
    }

    @Test
    public void whenThereAreWeatherConditionsShouldConcatenateRecommendations() {
        Recommendation recommendation = new Recommendation();
        String message = recommendation.getMessage(Arrays.asList("STORM", "HAIL"));
        assertEquals("carry umbrella, avoid going out without a car", message);
    }
}
