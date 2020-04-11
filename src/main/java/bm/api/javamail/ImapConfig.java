package bm.api.javamail;

public class ImapConfig {

    String host = "";
    String port = "";
    String username = "";
    String password = "";

    @Override
    public String toString() {
        return "ImapConfig{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
