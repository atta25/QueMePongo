public class Calculator implements Observer {
    @Override
    public void weatherAlertGenerated(User user) {
        user.calculate();
    }
}
