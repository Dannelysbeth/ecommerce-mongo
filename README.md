# 🛒 Ecommerce MongoDB Shop - Testing and Exploring MongoDB

This is a simple yet functional **Ecommerce Internet Shop** backend designed to test and demonstrate the capabilities of **MongoDB** in handling ecommerce functionalities. This project is focused on utilizing MongoDB document-based NoSQL features effectively and provides a small, clean implementation of essential ecommerce backend operations.

---

## 📋 Features

- **MongoDB Integration**: A fully persistent database using MongoDB for high scalability, flexibility, and powerful querying.
- **Basic Ecommerce Backend**: Includes foundational ecommerce operations like managing addresses and countries.
- **Lombok for Simplicity**: Streamlines Java code by reducing boilerplate with concise model annotations.
- **Spring Boot for APIs**: Provides a production-ready environment with RESTful APIs to interact with the database.
- **Testing MongoDB Capabilities**: Demonstrates the strengths of MongoDB's NoSQL model in handling ecommerce-like data.

---

## 🛠️ Technologies Used

- **Backend**: Java 21, Spring Boot, Spring Data MongoDB
- **Database**: MongoDB (NoSQL)
- **Utility Library**: Lombok for reducing boilerplate code
- **Build Tool**: Maven
- **Testing**: JUnit for unit testing

---

## 📋 Data Model

The project uses a simple yet comprehensive data model to represent common entities in an ecommerce system: `Address` and `Country`. Below are the key details:

### 🌍 `Country` Model

Represents a country in the ecommerce system.

```java
@Builder
@Data
public class Country {
    private long id;
    private String name;
    private String code; // ISO country code
}
```

| **Field**        | **Type** | **Description**                  |
|-------------------|----------|----------------------------------|
| `id`             | `long`   | Unique identifier for the country. |
| `name`           | `String` | Name of the country (e.g., "United States"). |
| `code`           | `String` | ISO code for the country.       |

---

### 🏠 `Address` Model

Stores address details of users in the system.

```java
@Builder
@Data
public class Address {
    private long id;
    @DBRef
    private Country country;
    private int unitNumber;
    private int streetNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
    private boolean isDefault;
}
```

| **Field**         | **Type**     | **Description**                                      |
|--------------------|--------------|----------------------------------------------------|
| `id`              | `long`       | Unique identifier for the address.                |
| `country`         | `Country`    | Linked `Country` object stored with MongoDB's DBRef for relations. |
| `unitNumber`      | `int`        | Unit or apartment number in the address.          |
| `streetNumber`    | `int`        | Street number.                                    |
| `addressLine1`    | `String`     | Primary address field (e.g., Street name).        |
| `addressLine2`    | `String`     | Secondary address field (optional).              |
| `city`            | `String`     | City name.                                        |
| `postalCode`      | `String`     | Postal/ZIP code for the address.                  |
| `isDefault`       | `boolean`    | Flag indicating if the address is the user's default one. |

---

## 🚀 Getting Started

### 📋 Prerequisites

Before running this project, ensure the following tools are installed:

1. **Java 21 SDK**
2. **MongoDB** (working instance)
3. **Maven** (build tool)

---

### 📦 Installation and Setup

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd ecommerce-mongodb-shop
   ```

2. **Set up MongoDB**:
   - Ensure MongoDB is running locally or update your connection string in the `application.properties` file accordingly.

3. **Build the project**:
   ```bash
   mvn clean install
   ```

4. **Run the project**:
   ```bash
   mvn spring-boot:run
   ```

5. The application will be available at `http://localhost:8080`.

---

### 📖 Usage

#### Available Endpoints

1. **Address Management**:
   - Add an address.
   - Retrieve all addresses.
   - Set an address as default.

2. **Country Management**:
   - Add a new country.
   - Retrieve country lists.
   - Link countries to addresses.

These endpoints can be tested using tools such as **Postman** or **cURL**.

---

## 📚 Testing MongoDB Capabilities

The purpose of this project is to explore key MongoDB features and how they can be effectively applied in a simple ecommerce system. You can experiment with the following MongoDB features:

1. **Document-based Storage**:
   - Easily handle nested and complex data structures, like `Address` containing a referenced `Country`.

2. **DBRef Relationships**:
   - Leveraging MongoDB's `@DBRef` annotation to create relations between collections (e.g., Address and Country).

3. **Query Capabilities**:
   - Perform dynamic queries to filter data as needed using Spring Data MongoDB.

4. **Prototyping**:
   - Quickly modify schema definitions for testing new features without downtime, thanks to MongoDB's flexible schema model.

---

## 👥 Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes following best practices.
4. Submit a pull request.

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## ❤️ Acknowledgements

Thank you for exploring this project! This project demonstrates how easy it is to integrate MongoDB with Java backend technology like Spring Boot. If you have any suggestions or find bugs, feel free to open an issue or submit a pull request.

Happy coding! 🎉