# Role-Based Ticketing System (Java)

A desktop-based ticketing system developed in **Java**, featuring role-based access for administrators and customers. The application supports event management, secure ticket purchasing, and real-time stock synchronisation, all built using core Object-Oriented Programming principles.

## Features

### Admin Functionality
- Full **CRUD operations** for events and ticket stock  
- Centralised control over event availability and inventory  
- Automatic stock updates following customer purchases  

### Customer Functionality
- Browse available events via a graphical interface  
- Search events using **ID-based lookup**  
- Filter events by language  
- Purchase tickets and complete checkout securely  

## Technical Implementation

- Built using **Swing (javax.swing)** components for the GUI  
- Utilised **event listeners** and an **MVC-style architecture** to improve navigation and maintain separation of concerns  
- Integrated secure payment options, including **PayPal** and **Credit Card** workflows  
- Implemented **real-time stock synchronisation** using:
  - `BufferedReader` and `BufferedWriter`
  - File I/O streams
  - Custom `toString()` overrides for receipt generation  

## Object-Oriented Design

The system applies core OOP principles throughout:

- **Encapsulation** for data protection  
- **Inheritance** to reduce duplication and promote reuse  
- **Interfaces** to define consistent behaviour across components  
- **Enums** for fixed sets such as roles and payment types  

Additionally, the project makes use of:
- Java **Collections Framework**
- Robust **exception handling**
- Modular class design to ensure **scalability** and **maintainability**

## Technologies Used

- Java  
- Swing (javax.swing)  
- File I/O  
- MVC-style architectural pattern  

## Notes

This project was developed as part of a learning-focused implementation to demonstrate GUI development, object-oriented design, and file-based persistence in Java.
