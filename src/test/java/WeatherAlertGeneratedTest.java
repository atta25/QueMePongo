import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import service.MailSender;
import service.NotificationService;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class WeatherAlertGeneratedTest {
    @Mock
    private Recommendation recommendation;
    @Mock
    private WeatherProvider weatherProvider;
    @Mock
    private NotificationService notificationService;
    @Mock
    private MailSender mailSender;
    @InjectMocks
    private NotificatorText notificatorText;
    @InjectMocks
    private NotificatorMail notificatorMail;
    private Calculator calculator;
    @Mock
    private User user;
    @Mock
    private User otherUser;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void executeObserversWhenWeatherAlertWasGenerated() {
        calculator = new Calculator();
        UserList userList = new UserList();
        userList.addUser(user);
        userList.addUser(otherUser);
        userList.addObserver(notificatorText);
        userList.addObserver(notificatorMail);
        userList.addObserver(calculator);
        when(notificatorText.getMessage()).thenReturn(anyString());
        when(notificatorMail.getMessage()).thenReturn(anyString());

        userList.weatherAlertWasGenerated();

        verify(notificationService, times(2)).notify(anyString());
        verify(mailSender, times(2)).send(anyString(), anyString());
        verify(user, times(1)).calculate();
        verify(otherUser, times(1)).calculate();
    }

    @Test
    public void whenThereAreWeatherConditionsShouldConcatenateRecommendations() {
        Recommendation recommendation = new Recommendation();
        String message = recommendation.getMessage(Arrays.asList("STORM", "HAIL"));
        assertEquals("carry umbrella, avoid going out without a car", message);
    }
}
