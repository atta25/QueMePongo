import java.util.ArrayList;
import java.util.List;

public class UserList {
    private List<User> users;
    private List<Observer> observers;

    public UserList() {
        this.users = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void weatherAlertWasGenerated() {
        this.users.forEach(user -> this.observers.forEach(observer -> observer.weatherAlertGenerated(user)));
    }
}
