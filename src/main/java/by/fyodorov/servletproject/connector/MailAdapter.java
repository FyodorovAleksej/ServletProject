package by.fyodorov.servletproject.connector;

import by.fyodorov.servletproject.exception.MailException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class MailAdapter {
    private Properties mailProps;
    private static final String PROPERTY_PATH = "/setting.properties";
    private static final String MAIL_KEY = "mail.smtps.user";
    private static final String PASSWORD_KEY = "mail.smtps.password";
    private static final String SUBJECT = "Servlet Project";

    public MailAdapter(String path) throws MailException {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(path + PROPERTY_PATH)));
        } catch (FileNotFoundException e) {
            throw new MailException("can't find file = \"" + PROPERTY_PATH + "\"", e);
        } catch (IOException e) {
            throw new MailException("can't read file = \"" + PROPERTY_PATH + "\"", e);
        }
        mailProps = props;
    }

    public void send(String text, String address) throws MailException {
        try {
            Session mailSession = Session.getDefaultInstance(mailProps);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(mailProps.getProperty(MAIL_KEY)));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
            message.setSubject(SUBJECT);
            message.setText(text);

            Transport transport = mailSession.getTransport();
            transport.connect(mailProps.getProperty(MAIL_KEY), mailProps.getProperty(PASSWORD_KEY));
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new MailException("Can't send message", e);
        }
    }
}
