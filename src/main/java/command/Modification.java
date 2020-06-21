package command;

import domain.User;

public interface Modification {
    void apply(User user);
    void undo(User user);
}
