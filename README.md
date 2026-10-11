# ResQ – Accident Reporting and Emergency Response Support System

## Team Details

- **College:** KIT College
- **Department:** Electrical and Electronics Engineering (EEE)
- **Year:** Third Year

### Team Members

| S. No. | Name | Roll Number |
|---|---|---|
| 1 | AMAL KRISHNA S | 711524BEE003 |
| 2 | KRISHNA KUMAR AP | 711524BEE029 |

## Project Description

ResQ is an accident reporting and emergency response support system designed to record accident details, identify accident locations, and record a suitable hospital destination.

The system uses a web-based dashboard connected to a Java backend. It captures information such as accident location, number of vehicles involved, number of people injured, serious injuries, and accident severity.

ResQ is an academic prototype that demonstrates accident report processing and emergency-response coordination workflows. Police and ambulance actions are simulated and do not contact real emergency services.

## Technologies and Tools Used

- Java
- HTML
- CSS
- JavaScript
- Leaflet.js for interactive maps
- OpenStreetMap and configured map tile providers
- Visual Studio Code
- Git and GitHub

## Main Features

- Accident report submission
- Accident location display on a map
- Injury and severity details
- Hospital destination recording
- Java backend API
- Backend health-check endpoint

## Project Structure

```text
OOPS-PROJ/
├── src/
│   └── ApiServer.java
├── web/
│   └── ambulance-map.html
├── README.md
└── .gitignore
```

## How to Run

1. Install a compatible Java Development Kit (JDK).
2. Open the project folder in VS Code.
3. Compile the backend using the appropriate command for the project structure.
4. Start the Java backend.
5. Open `web/ambulance-map.html` in a browser.
6. Test the backend using `http://localhost:8080/api/health`.

## Limitations

- Police and ambulance actions are simulated.
- The prototype does not dispatch real emergency services.
- An internet connection is required for external map services.

## Future Enhancements

- Database integration for persistent accident reports
- Secure user authentication
- Integration with authorized emergency service providers
- Improved report history and tracking
- Automated notifications to authorized responders

## Project Status

Academic project developed for demonstration and final review.
