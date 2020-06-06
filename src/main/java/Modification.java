public interface Modification {
    void apply(User user);
    void undo(User user);
}
