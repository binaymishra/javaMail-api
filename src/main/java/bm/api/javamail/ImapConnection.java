package bm.api.javamail;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ImapConnection {

    private static final String IMAP = "imap";
    private static final String DEFAULT_HOST = "imap.gmail.com";
    private static final String DEFAULT_PORT = "993";

    private Properties properties;

    private Store store;

    public ImapConnection() {
        properties = new Properties();
        properties.setProperty("mail.imap.host", DEFAULT_HOST);
        properties.setProperty("mail.imap.port", DEFAULT_PORT);
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port", DEFAULT_PORT);
    }

    public ImapConnection(ImapConfig imapConfig) throws MessagingException {
        this();
        properties.setProperty("mail.imap.host", imapConfig.host);
        properties.setProperty("mail.imap.port", String.valueOf(imapConfig.port));
        properties.setProperty("mail.imap.socketFactory.port", String.valueOf(imapConfig.port));
        Session session = Session.getDefaultInstance(properties);
        store = connect(session, imapConfig);
    }

    public ImapConnection(String host, String port, String username, String password) throws MessagingException {
        this();
        properties.setProperty("mail.imap.host", host);
        properties.setProperty("mail.imap.port", port);
        properties.setProperty("mail.imap.socketFactory.port", port);
        Session session = Session.getDefaultInstance(properties);
        store = connect(session, username, password);
    }

    public ImapConnection(String host, String username, String password) throws MessagingException {
        this();
        properties.setProperty("mail.imap.host", host);
        Session session = Session.getDefaultInstance(properties);
        store = connect(session, username, password);
    }

    public ImapConnection(String username, String password) throws MessagingException {
        this();
        Session session = Session.getDefaultInstance(properties);
        store = connect(session, username, password);
    }


    private Store connect(Session session, String username, String password) throws MessagingException {
        Store store = session.getStore(IMAP);
        store.connect(username, password);
        return store;
    }


    private Store connect(Session session, ImapConfig imapConfig) throws MessagingException {
        Store store = session.getStore(IMAP);
        store.connect(imapConfig.username, imapConfig.password);
        return store;
    }

    public Store getStore() {
        return store;
    }
}
