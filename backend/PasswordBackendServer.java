package backend;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import validators.PasswordDigitValidator;
import validators.PasswordLengthValidator;
import validators.PasswordLowerCaseValidator;
import validators.PasswordSymbolValidator;
import validators.PasswordUpperCaseValidator;

public class PasswordBackendServer {
    private final HttpServer server;

    public PasswordBackendServer(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/violated-rules", exchange -> {
            if (!"GET".equals(exchange.getRequestMethod())) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String password = getQueryParam(exchange, "password");
            String response = getViolatedRulesJson(password);

            exchange.getResponseHeaders().set("Content-Type", "application/json");
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            sendResponse(exchange, response);
        });
    }

    public void start() {
        server.start();
    }

    private String getViolatedRulesJson(String password) {
        PasswordChecker passwordChecker = new PasswordChecker(
            List.of(
                new PasswordDigitValidator(),
                new PasswordLengthValidator(),
                new PasswordLowerCaseValidator(),
                new PasswordSymbolValidator(),
                new PasswordUpperCaseValidator()
            )
        );

        passwordChecker.validate(password);
        List<String> violatedRulesList = passwordChecker.getFailedRules();

        StringBuilder json = new StringBuilder("[");

        for (int i = 0; i < violatedRulesList.size(); i++) {
            if (i > 0) {
                json.append(",");
            }

            json.append("\"").append(escapeJson(violatedRulesList.get(i))).append("\"");
        }

        json.append("]");
        return json.toString();
    }

    private String getQueryParam(HttpExchange exchange, String name) {
        String query = exchange.getRequestURI().getRawQuery();

        if (query == null) {
            return "";
        }

        String[] params = query.split("&");

        for (int i = 0; i < params.length; i++) {
            String[] pair = params[i].split("=", 2);
            String key = URLDecoder.decode(pair[0], StandardCharsets.UTF_8);

            if (name.equals(key)) {
                if (pair.length == 1) {
                    return "";
                }

                return URLDecoder.decode(pair[1], StandardCharsets.UTF_8);
            }
        }

        return "";
    }

    private String escapeJson(String value) {
        return value
            .replace("\\", "\\\\")
            .replace("\"", "\\\"");
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        byte[] responseBytes = response.getBytes(StandardCharsets.UTF_8);

        exchange.sendResponseHeaders(200, responseBytes.length);

        try (OutputStream outputStream = exchange.getResponseBody()) {
            outputStream.write(responseBytes);
        }
    }
}
