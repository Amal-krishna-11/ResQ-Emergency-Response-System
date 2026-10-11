
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.IOException;

public class ApiServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0);

        server.createContext("/api/health", exchange -> {
            exchange.getResponseHeaders().set(
                "Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set(
                "Access-Control-Allow-Methods", "GET, OPTIONS");

            if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
                exchange.sendResponseHeaders(204, -1);
                exchange.close();
                return;
            }

            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                byte[] error = "GET required".getBytes(
                    StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(405, error.length);

                try (OutputStream output = exchange.getResponseBody()) {
                    output.write(error);
                }
                return;
            }

            byte[] bytes =
                "{\"status\":\"Java backend connected\"}"
                .getBytes(StandardCharsets.UTF_8);

            exchange.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(bytes);
            }
        });

        server.createContext("/api/accidents", AccidentApi::handle);
        server.start();

        System.out.println("==================================");
        System.out.println(" RESQ JAVA BACKEND RUNNING");
        System.out.println(" http://localhost:8080/api/health");
        System.out.println(" Waiting for dashboard reports...");
        System.out.println("==================================");
    }
}