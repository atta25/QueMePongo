package observer;

import domain.User;
import java.util.List;

// acá no se me ocurrió un buen nombre y lo dejé como observer.Observer
public interface Observer {
    void weatherAlertGenerated(User user, List<String> alerts);
}