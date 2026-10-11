
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AccidentManager manager = new AccidentManager();
        ContactManager contacts = new ContactManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== ACCIDENT RESPONSE SYSTEM ===");
            System.out.println("1. Register Accident\n2. View Reports");
            System.out.println("3. Search Accident\n4. Delete Accident");
            System.out.println("5. Emergency Contacts\n6. Statistics\n7. Exit");
            System.out.print("Choose option: ");
            try {
                int choice = in.nextInt();
                in.nextLine();
                switch (choice) {
                    case 1: register(in, manager); break;
                    case 2: manager.displayAllAccidents(); break;
                    case 3:
                        System.out.print("Accident ID: ");
                        manager.searchAccident(in.nextInt());
                        in.nextLine();
                        break;
                    case 4:
                        System.out.print("Accident ID: ");
                        manager.deleteAccident(in.nextInt());
                        in.nextLine();
                        break;
                    case 5: contactMenu(in, contacts); break;
                    case 6: manager.displayStatistics(); break;
                    case 7: running = false; break;
                    default: System.out.println("Choose 1 to 7.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Enter a valid number.");
                in.nextLine();
            }
        }
        in.close();
        System.out.println("Program closed.");
    }

    private static void register(Scanner in, AccidentManager m) {
        try {
            System.out.print("Accident ID: ");
            int id = in.nextInt();
            in.nextLine();
            System.out.print("Location: ");
            String place = in.nextLine();
            System.out.print("Vehicles involved: ");
            int vehicles = in.nextInt();
            System.out.print("People injured: ");
            int injured = in.nextInt();
            System.out.print("Seriously injured: ");
            int serious = in.nextInt();
            System.out.print("Latitude (-90 to 90): ");
            double lat = in.nextDouble();
            System.out.print("Longitude (-180 to 180): ");
            double lon = in.nextDouble();
            in.nextLine();
            Accident a = new Accident(id, place, vehicles, injured, serious, lat, lon);
            if (m.addAccident(a)) a.showResponseAdvice();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void contactMenu(Scanner in, ContactManager m) {
        System.out.println("1. Add Contact\n2. View Contacts");
        System.out.print("Choose: ");
        int option = in.nextInt();
        in.nextLine();
        if (option == 1) {
            System.out.print("Name: ");
            String name = in.nextLine();
            System.out.print("Phone: ");
            String phone = in.nextLine();
            System.out.print("Role: ");
            String role = in.nextLine();
            try {
                m.add(new EmergencyContact(name, phone, role));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (option == 2) m.displayAll();
        else System.out.println("Invalid option.");
    }
}