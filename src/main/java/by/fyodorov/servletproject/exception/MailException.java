package by.fyodorov.servletproject.exception;

public class MailException extends Exception {
    public MailException(String message) {
        super(message);
    }

    public MailException(String message, Throwable e) {
        super(message, e);
    }
}
