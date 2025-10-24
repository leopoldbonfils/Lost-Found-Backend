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

