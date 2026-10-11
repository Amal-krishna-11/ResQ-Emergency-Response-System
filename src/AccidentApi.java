
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccidentApi {
    public static void handle(HttpExchange ex) throws IOException {
        ex.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        ex.getResponseHeaders().set("Access-Control-Allow-Methods", "POST, OPTIONS");
        ex.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");

        if (ex.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            ex.sendResponseHeaders(204, -1);
            ex.close();
            return;
        }

        if (!ex.getRequestMethod().equalsIgnoreCase("POST")) {
            send(ex, 405, "POST required");
            return;
        }

        try {
            Map<String, String> data = new HashMap<>();
            String raw = new String(
                ex.getRequestBody().readAllBytes(),
                StandardCharsets.UTF_8
            );

            for (String pair : raw.split("&")) {
                String[] parts = pair.split("=", 2);
                if (parts.length == 2) {
                    String key = URLDecoder.decode(
                        parts[0], StandardCharsets.UTF_8);
                    String value = URLDecoder.decode(
                        parts[1], StandardCharsets.UTF_8);
                    data.put(key, value);
                }
            }

            String place = required(data, "location");
            String hospital = required(data, "destination");
            int vehicles = Integer.parseInt(required(data, "vehicles"));
            int injured = Integer.parseInt(required(data, "injured"));
            int serious = Integer.parseInt(required(data, "serious"));

            if (vehicles < 1 || vehicles > 100 ||
                injured < 0 || injured > 1000 ||
                serious < 0 || serious > injured) {
                throw new IllegalArgumentException("Invalid accident details");
            }

            ArrayList<Accident> reports = AccidentFile.load();
            int id = 1;

            for (Accident old : reports) {
                id = Math.max(id, old.getAccidentId() + 1);
            }

            Accident report = new Accident(
                id, place, vehicles, injured, serious,
                Double.NaN, Double.NaN
            );

            reports.add(report);
            AccidentFile.save(reports);

            System.out.println("\n========== RESQ REPORT ==========");
            System.out.println("Report ID: " + id);
            System.out.println("Accident location: " + place);
            System.out.println("Hospital destination: " + hospital);
            System.out.println("Vehicles involved: " + vehicles);
            System.out.println("People injured: " + injured);
            System.out.println("Seriously injured: " + serious);
            System.out.println("Severity: " + report.getSeverity());
            System.out.println("Control room: Demo event logged");
            System.out.println("Police: Simulation only; not sent");
            System.out.println("Ambulance: Simulation only; not sent");
            System.out.println("Hospital: Destination recorded");
            System.out.println("=================================\n");

            send(ex, 200, "Report saved. ID: " + id
                + ", Severity: " + report.getSeverity());

        } catch (NumberFormatException e) {
            send(ex, 400, "Invalid number in accident details.");
        } catch (Exception e) {
            System.err.println("Report rejected: " + e.getMessage());
            send(ex, 400, "Report failed. Check all accident details.");
        }
    }

    private static String required(
        Map<String, String> data, String key) {
        String value = data.get(key);

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing " + key);
        }

        return value.trim();
    }

    private static void send(
        HttpExchange ex, int code, String message) throws IOException {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        ex.getResponseHeaders().set(
            "Content-Type", "text/plain; charset=UTF-8");

        ex.sendResponseHeaders(code, bytes.length);

        try (var output = ex.getResponseBody()) {
            output.write(bytes);
        }
    }
}