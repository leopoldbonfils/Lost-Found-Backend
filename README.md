# 🧳 Lost & Found Management System

A Spring Boot web application that helps users **report lost and found items**, manage locations, and connect people who have lost or found something.  
Built with **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**.

---

## 🚀 Features

- 🔐 User registration and login  
- 🧾 Report lost or found items  
- 📍 Manage and search by location  
- 👥 Relationship between users and items (One-to-Many)  
- 🧩 Category and item type management  
- 🗂️ Full CRUD operations on all entities  
- 🗄️ PostgreSQL database integration  

---

## 🧱 Project Structure

Lost-FoundBackend/

├── src/main/java/com/Lost/FoundBackend/Lost/FoundBackend/

│ ├── controller/ # REST Controllers

│ ├── model/ # JPA Entities

│ ├── repository/ # JPA Repositories

│ ├── service/ # Business Logic Layer

│ └── LostFoundBackendApplication.java # Main Spring Boot App

├── src/main/resources/

│ ├── application.properties

│ └── static/ | templates/

└── pom.xml


---

## 🧩 Entities Overview

| Entity | Description | Relationship |
|--------|--------------|---------------|
| **User** | Stores user information (name, email, phone, etc.) | One-to-Many with Item |
| **Item** | Represents a lost or found item | Many-to-One with User, Many-to-One with Location |
| **Category** | Defines item categories (e.g., Electronics, Documents) | One-to-Many with Item |
| **Location** | Represents where an item was found or lost | One-to-Many with Item |
| **Report** | Links found/lost details and status updates | Many-to-One with Item |

---

## ⚙️ Tech Stack

- **Backend:** Spring Boot 3.5.x  
- **Database:** PostgreSQL  
- **ORM:** Spring Data JPA / Hibernate  
- **Build Tool:** Maven  
- **Language:** Java 21  
- **Testing:** JUnit & Spring Boot Test  

---

## 💾 Database Configuration

In your `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/lost_found_db
spring.datasource.username=postgres
spring.datasource.password=5Rwandan
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080
```
▶️ How to Run the Project

1️⃣ Clone the Repository

    git clone https://github.com/leopoldbonfils/Lost-Found-Backend.git
    cd Lost-Found-Backend

2️⃣ Configure PostgreSQL

   Create a database named lost_found_db

   Update application.properties with your DB credentials

3️⃣ Run the Application

    mvn spring-boot:run

4️⃣ Access the App

Open your browser and go to:

    http://localhost:8080

🧪 Example Endpoints (REST API)
Method	Endpoint	Description
POST	/api/users	Register new user
GET	/api/users	List all users
POST	/api/items	Report lost/found item
GET	/api/items/{id}	Get item by ID
PUT	/api/items/{id}	Update item details
DELETE	/api/items/{id}	Delete item
GET	/api/locations	List all locations


