package service;

public interface MailSender {
    void send(String address, String message);
}
