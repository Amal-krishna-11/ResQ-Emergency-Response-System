
import java.io.IOException;
import java.util.ArrayList;

public class AccidentManager {
    private ArrayList<Accident> reports = AccidentFile.load();

    public boolean addAccident(Accident report) {
        for (Accident a : reports) {
            if (a.getAccidentId() == report.getAccidentId()) {
                System.out.println("Accident ID already exists.");
                return false;
            }
        }

        reports.add(report);

        try {
            AccidentFile.save(reports);
            System.out.println("Report registered successfully.");
            return true;
        } catch (IOException e) {
            reports.remove(report);
            System.out.println("Could not save report: " + e.getMessage());
            return false;
        }
    }

    public void displayAllAccidents() {
        if (reports.isEmpty()) {
            System.out.println("No accident reports available.");
            return;
        }

        for (Accident a : reports) {
            System.out.println("--------------------");
            a.displayDetails();
        }
    }

    public void searchAccident(int id) {
        for (Accident a : reports) {
            if (a.getAccidentId() == id) {
                a.displayDetails();
                return;
            }
        }

        System.out.println("No accident found with ID: " + id);
    }

    public void deleteAccident(int id) {
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).getAccidentId() == id) {
                Accident removed = reports.remove(i);

                try {
                    AccidentFile.save(reports);
                    System.out.println("Report deleted successfully.");
                } catch (IOException e) {
                    reports.add(i, removed);
                    System.out.println("Could not delete report: "
                        + e.getMessage());
                }

                return;
            }
        }

        System.out.println("No accident found with ID: " + id);
    }

    public int getTotalReports() {
        return reports.size();
    }

    public void displayStatistics() {
        int high = 0, medium = 0, low = 0;

        for (Accident a : reports) {
            if (a.getSeverity().equals("High")) {
                high++;
            } else if (a.getSeverity().equals("Medium")) {
                medium++;
            } else {
                low++;
            }
        }

        System.out.println("Total Reports: " + reports.size());
        System.out.println("High Severity: " + high);
        System.out.println("Medium Severity: " + medium);
        System.out.println("Low Severity: " + low);
    }
}