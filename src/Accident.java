
public class Accident {
    private int accidentId, vehiclesInvolved, peopleInjured, seriouslyInjured;
    private String location, severity;
    private double latitude, longitude;

    public Accident(int id, String place, int vehicles, int injured,
                    int serious, double lat, double lon) {
        if (id <= 0 || place.trim().isEmpty() || place.contains("|") ||
            vehicles <= 0 || injured < 0 || serious < 0 || serious > injured ||
            !((Double.isNaN(lat) && Double.isNaN(lon)) ||
            (lat >= -90 && lat <= 90 && lon >= -180 && lon <= 180)))
            throw new IllegalArgumentException("Invalid accident details.");
        accidentId = id;
        location = place;
        vehiclesInvolved = vehicles;
        peopleInjured = injured;
        seriouslyInjured = serious;
        latitude = lat;
        longitude = lon;
        calculateSeverity();
    }

    private void calculateSeverity() {
        if (vehiclesInvolved >= 3 || peopleInjured >= 5 || seriouslyInjured >= 2)
            severity = "High";
        else if (vehiclesInvolved == 2 || peopleInjured >= 2)
            severity = "Medium";
        else severity = "Low";
    }

    public int getAccidentId() { return accidentId; }
    public String getLocation() { return location; }
    public int getVehiclesInvolved() { return vehiclesInvolved; }
    public int getPeopleInjured() { return peopleInjured; }
    public int getSeriouslyInjured() { return seriouslyInjured; }
    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }
    public String getSeverity() { return severity; }

    public void displayDetails() {
        System.out.println("Accident ID: " + accidentId);
        System.out.println("Location: " + location);
        if (Double.isNaN(latitude))
            System.out.println("Coordinates: Not available");
        else
            System.out.println("Coordinates: " + latitude + ", " + longitude);
        System.out.println("Vehicles: " + vehiclesInvolved);
        System.out.println("People Injured: " + peopleInjured);
        System.out.println("Seriously Injured: " + seriouslyInjured);
        System.out.println("Severity: " + severity);
    }

    public void showResponseAdvice() {
        if (severity.equals("High"))
            System.out.println("Seek immediate emergency assistance.");
        else if (severity.equals("Medium"))
            System.out.println("Prompt assessment is recommended.");
        else System.out.println("Check for hazards and injuries.");
        System.out.println("Contact local emergency services when needed.");
    }
}