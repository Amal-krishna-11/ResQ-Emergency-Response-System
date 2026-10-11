# ResQ – Emergency Accident Reporting System using Java OOP

A Java-based Emergency Accident Reporting System developed primarily using **Object-Oriented Programming (OOP)** concepts. The project records accident details, manages emergency contacts, estimates accident severity, and records hospital destination information. A web interface supports accident reporting and location display.

## Overview

ResQ demonstrates how Java OOP principles can be applied to an emergency accident reporting scenario.

The application allows users to:

- Record accident information and location.
- Record the number of vehicles involved.
- Record the number of injured and seriously injured people.
- Estimate accident severity.
- Record a hospital destination.
- Manage emergency contact information.
- Store accident and contact records in text files.
- Access accident-reporting functionality through a web interface and Java API.

**Important:** The current project records information and simulates emergency-service actions. It does not automatically dispatch real ambulances or send notifications to police or hospitals.

## Problem Statement

Accident information needs to be recorded and organized quickly so that details such as the accident location, number of injured people, severity, and intended hospital destination can be reviewed. Manual recording can make information management difficult.

ResQ demonstrates a software-based approach to organizing accident reports using Java classes, file handling, API communication, and a web interface.

## Objectives

- Develop an accident reporting application using Java.
- Apply Object-Oriented Programming concepts.
- Organize accident and emergency-contact information into separate classes.
- Record and retrieve information using file handling.
- Estimate accident severity based on the implemented logic.
- Provide a web interface for accident reporting.
- Demonstrate communication between the web interface and Java backend.

## Features

- Accident detail recording.
- Accident location recording.
- Vehicle and injury count recording.
- Accident severity estimation.
- Hospital destination recording.
- Emergency contact management.
- File-based storage of accident and contact records.
- Java API server for backend communication.
- Web-based accident reporting interface.
- Simulated emergency-service actions for demonstration.

## Technologies Used

- **Programming Language:** Java
- **Programming Approach:** Object-Oriented Programming (OOP)
- **Web Technologies:** HTML, CSS, and JavaScript, where implemented
- **Backend:** Java API server
- **Data Storage:** Text files
- **IDE:** Visual Studio Code
- **Version Control:** Git
- **Repository Hosting:** GitHub

## Project Structure

```text
ResQ-Emergency-Response-System/
│
├── src/
│   ├── Accident.java
│   ├── AccidentApi.java
│   ├── AccidentFile.java
│   ├── AccidentManager.java
│   ├── ApiServer.java
│   ├── ContactManager.java
│   ├── EmergencyContact.java
│   └── Main.java
│
├── web/
│   └── ambulance-map.html
│
├── out/                    # Generated class files; ignored by Git
│
├── accidents.txt
├── contacts.txt
├── .gitignore
└── README.md
```

## Classes Used

The project contains the following main Java classes, based on their intended responsibilities.

### Accident

Represents accident-related information, such as location, vehicles involved, injured people, and severity, according to the implemented fields.

### AccidentApi

Handles API-related functionality for exchanging accident-reporting information.

### AccidentFile

Supports file-related operations for accident records.

### AccidentManager

Organizes accident-reporting and accident-management operations.

### ApiServer

Runs the Java backend API server and handles incoming requests.

### ContactManager

Manages emergency-contact-related operations.

### EmergencyContact

Represents emergency contact information.

### Main

Provides the main entry point for running the Java application.

*The precise responsibilities of each class should be verified against the source code.*

## Algorithm

1. Start the application.
2. Initialize the required Java components.
3. Accept accident details through the available application interface.
4. Process the accident information through the backend.
5. Estimate severity using the implemented logic.
6. Record the selected hospital destination.
7. Store accident or contact information in the appropriate text file.
8. Display the report or result.
9. Simulate emergency-service actions where applicable.
10. Continue accepting requests while the application is running.

## Sample Output

```text
========== RESQ REPORT ==========
Report ID: 128
Accident location: nemmara, palakkad, kerala
Hospital destination: government hospital, palakkad
Vehicles involved: 1
People injured: 4
Seriously injured: 2
Severity: High
Control room: Demo event logged
Police: Simulation only; not sent
Ambulance: Simulation only; not sent
Hospital: Destination recorded
=================================
```

*This is an illustrative example of the report format. Actual values depend on the input provided during execution.*

## OOP Concepts Used

### Classes and Objects

The application uses separate Java classes to represent accidents, emergency contacts, and application components.

### Encapsulation

Related data and operations are grouped within classes where implemented.

### Abstraction

Application components can expose operations while hiding internal implementation details where the code supports this.

### Modularity

Separate classes organize accident management, file handling, API communication, and emergency-contact management.

### Maintainability

Dividing responsibilities across classes helps make the application easier to understand, test, and extend.

*Only claim inheritance or polymorphism if these concepts are actually implemented in the source code.*

## Running the Project

1. Install a compatible Java Development Kit (JDK).
2. Open the `OOPS-PROJ` folder in Visual Studio Code.
3. Compile the Java source files using the project's required commands.
4. Start the Java API server.
5. Open `web/ambulance-map.html` in a browser or use the configured frontend setup.
6. Submit a test accident report.
7. Verify the report output and stored data.

## Current Limitations

- Police, ambulance, and hospital actions are simulated rather than connected to real emergency services.
- The project uses text files for data storage.
- Real-time ambulance tracking and verified hospital availability are not provided unless separately integrated.
- The application is intended for academic demonstration and further development.

## Future Enhancements

- Integrate verified emergency-service APIs.
- Add real-time ambulance tracking.
- Improve hospital selection based on distance and availability.
- Integrate a database for structured data storage.
- Add authentication and access control.
- Improve validation and error handling.
- Enhance the web interface and report history.

## Learning Outcomes

- Practical application of Java OOP concepts.
- Experience organizing a project using multiple Java classes.
- Understanding file handling and data persistence.
- Understanding communication between a web interface and a Java backend.
- Experience using Git and GitHub for version control.
- Applying software development concepts to an emergency-reporting use case.

## Team Details

**College:** KIT College  
**Department:** Electrical and Electronics Engineering (EEE)  
**Year:** Third Year

### Team Members

| S. No. | Name | Roll Number |
|---|---|---|
| 1 | AMAL KRISHNA S | 711524BEE003 |
| 2 | KRISHNA KUMAR AP | 711524BEE029 |

## Project Guide

**ResQ – Emergency Accident Reporting System using Java OOP**

## License

This project is developed for educational and academic purposes.
