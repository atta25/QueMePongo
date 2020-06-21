package command;

import domain.AttireGenerator;
import domain.User;
import observer.Observer;
import weather.AccuProvider;
import java.util.List;

public class DailySuggestionCalculator implements Observer {
    @Override
    public void weatherAlertGenerated(User user, List<String> alerts) {
        new AttireGenerator(new AccuProvider()).generateSuggestions(user);
    }
}
