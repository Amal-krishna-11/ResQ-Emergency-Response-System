
public class EmergencyContact {
    private String name;
    private String phone;
    private String role;

    public EmergencyContact(String name, String phone, String role) {
        if (name.trim().isEmpty() || phone.trim().isEmpty()
                || role.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "All contact fields are required.");
        }
        this.name = name;
        this.phone = phone;
        this.role = role;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Role: " + role);
    }

    public String toFileText() {
        return name + "|" + phone + "|" + role;
    }
}