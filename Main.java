import backend.PasswordBackendServer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PasswordBackendServer server = new PasswordBackendServer(8080);

        server.start();
        System.out.println("Password checker backend running at http://localhost:8080");
    }
}
