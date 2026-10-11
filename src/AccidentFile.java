
import java.io.*;
import java.util.ArrayList;

public class AccidentFile {
    private static final String FILE = "accidents.txt";

    public static void save(ArrayList<Accident> reports)
            throws IOException {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(FILE))) {
            for (Accident a : reports) {
                out.println(a.getAccidentId() + "|" + a.getLocation()
                    + "|" + a.getVehiclesInvolved()
                    + "|" + a.getPeopleInjured()
                    + "|" + a.getSeriouslyInjured()
                    + "|" + a.getLatitude()
                    + "|" + a.getLongitude());
            }

            if (out.checkError()) {
                throw new IOException("Failed to write accident reports.");
            }
        }
    }

    public static ArrayList<Accident> load() {
        ArrayList<Accident> list = new ArrayList<>();
        File file = new File(FILE);

        if (!file.exists()) {
            return list;
        }

        try (BufferedReader in = new BufferedReader(
                new FileReader(file))) {
            String line;

            while ((line = in.readLine()) != null) {
                try {
                    String[] d = line.split("\\|", -1);

                    if (d.length != 5 && d.length != 7) {
                        continue;
                    }

                    double lat = d.length == 7
                        ? Double.parseDouble(d[5]) : Double.NaN;
                    double lon = d.length == 7
                        ? Double.parseDouble(d[6]) : Double.NaN;

                    Accident a = new Accident(
                        Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Integer.parseInt(d[3]),
                        Integer.parseInt(d[4]),
                        lat,
                        lon
                    );

                    boolean duplicate = false;

                    for (Accident old : list) {
                        if (old.getAccidentId() == a.getAccidentId()) {
                            duplicate = true;
                            break;
                        }
                    }

                    if (!duplicate) {
                        list.add(a);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(
                        "Skipping an invalid saved report.");
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load reports: "
                + e.getMessage());
        }

        return list;
    }
}