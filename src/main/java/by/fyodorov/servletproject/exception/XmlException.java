package by.fyodorov.servletproject.exception;

public class XmlException extends Exception {
    public XmlException(String message) {
        super(message);
    }

    public XmlException(String message, Throwable e) {
        super(message, e);
    }
}
