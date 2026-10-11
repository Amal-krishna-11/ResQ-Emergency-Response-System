
import java.io.*;
import java.util.ArrayList;

public class ContactManager {
    private ArrayList<EmergencyContact> contacts = new ArrayList<>();
    private final String file = "contacts.txt";

    public ContactManager() {
        load();
    }

    public void add(EmergencyContact contact) {
        contacts.add(contact);
        save();
        System.out.println("Contact saved successfully.");
    }

    public void displayAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts saved.");
            return;
        }
        for (EmergencyContact c : contacts) {
            System.out.println("----------------");
            c.display();
        }
    }

    private void save() {
        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            for (EmergencyContact c : contacts)
                out.println(c.toFileText());
        } catch (IOException e) {
            System.out.println("Could not save contacts.");
        }
    }

    private void load() {
        File savedFile = new File(file);
        if (!savedFile.exists()) return;

        try (BufferedReader in =
                 new BufferedReader(new FileReader(savedFile))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] d = line.split("\\|", -1);
                if (d.length == 3)
                    contacts.add(new EmergencyContact(d[0], d[1], d[2]));
            }
        } catch (IOException e) {
            System.out.println("Could not load contacts.");
        }
    }
}