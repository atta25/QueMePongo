package repository;

import domain.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;
    private static final UserRepository instance = new UserRepository();

    private UserRepository() {
        users = new ArrayList<>();
    }

    public static UserRepository getInstance(){
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
