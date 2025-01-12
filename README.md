# Ecommerce MongoDB Shop

This repository contains the source code for the **Ecommerce MongoDB Shop** project. It is a backend application built with **Java**, **Spring Framework**, **MongoDB**, and **Lombok**, designed to manage ecommerce functionalities like user addresses, countries, and related data, with clean architecture and an efficient data persistence layer.

---

## 📋 Features

- **Spring Boot Backend**: A robust and scalable backend built with the Spring Framework.
- **MongoDB Integration**: A NoSQL database for lightweight, scalable storage of data.
- **Lombok for Cleaner Code**: Simplifies model creation using concise annotations.
- **Address Management**: Support for saving, retrieving, and marking addresses as default.

---

## 📂 Project Structure

The project follows a modular and clean architecture. Below is an overview of the key components:

- **`model`**: Contains the data models, such as `Address` and `Country`. These models are annotated for MongoDB and leverage Lombok for eliminating boilerplate code.
- **`repository`**: Contains MongoDB repositories for handling data persistence.
- **`service`**: The service layer encapsulates business logic and ensures reusability.
- **`controller`**: RESTful APIs to expose the underlying functionalities to external systems or frontend apps.
- **`configuration`**: Project configuration files, including database, application settings, etc.

### Example: Address Model

The `Address` model represents a user's stored address. It includes fields for country, postal code, city, and more. For example:

- **`isDefault`**: A `boolean` field that determines whether this address is the default address for the user.

---

## 🚀 Getting Started

### Prerequisites

Before you start, make sure you have the following installed:

- **Java 21 SDK**
- **MongoDB** (for the database)
- **Maven** (build tool)

### Installation and Setup

1. Clone the repository:

   ```bash
   git clone <repository-url>
   cd ecommerce-mongodb-shop
   ```

2. Configure the MongoDB connection in the `application.yml` or `application.properties` file.

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. The backend will start on `http://localhost:8080`.

---

## 📖 API Endpoints

This application provides RESTful endpoints to perform operations related to addresses, countries, and other ecommerce data.

### Address Operation Examples:
- **Add an Address**
- **Retrieve a User's Addresses**
- **Set an Address as Default**

More API endpoint details will follow as the project evolves.

---

## 🛠️ Technologies Used

- **Backend**: Spring Boot, Java 21
- **Database**: MongoDB
- **Utility Library**: Lombok
- **Build Tool**: Maven


---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## ❤️ Acknowledgements

Thank you for exploring this project! If you have ideas, find bugs, or want to contribute, feel free to open an issue or submit a pull request.

---

Feel free to share feedback and connect! 🎉 Happy coding!