# 🏦 Spring Boot Banking App

A simple modular Spring Boot banking application that supports user registration and login using REST APIs. Built with:

- ✅ Spring Boot 3.5
- ✅ Spring Web (REST APIs)
- ✅ Spring Data JPA with H2 Database
- ✅ Maven
- ✅ IntelliJ IDEA

## 📂 Project Structure

```
springboot-banking-app/
├── .mvn/                      # Maven wrapper support
├── mvnw / mvnw.cmd           # Maven wrapper scripts
├── pom.xml                   # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/com/bank/app/
│   │   │   ├── controller/       # AuthController (REST endpoints)
│   │   │   ├── dto/              # ResponseMessage DTO
│   │   │   ├── model/            # User model
│   │   │   ├── repository/       # UserRepository (JPA interface)
│   │   │   └── service/          # UserService (business logic)
│   │   └── resources/            # application.properties
│   └── test/                     # JUnit test classes
```

## 🧪 Features

- 🔐 **Register a user** via `/api/auth/register`
- 🔑 **Login a user** via `/api/auth/login`
- 🗂️ **File-based H2 database** for persistence across restarts
- ✅ Proper JSON responses + HTTP status codes

## 📌 API Endpoints

### Register User

```
POST /api/auth/register
Content-Type: application/json

{
  "username": "john",
  "password": "secret"
}
```

**Responses:**
- `201 Created`: User registered successfully
- `409 Conflict`: Username already exists

---

### Login User

```
POST /api/auth/login
Content-Type: application/json

{
  "username": "john",
  "password": "secret"
}
```

**Responses:**
- `200 OK`: Login successful
- `401 Unauthorized`: Invalid credentials or rate-limited

## 💻 Run Locally

1. Clone the repo
2. Run the app with IntelliJ or using Maven:

```bash
./mvnw spring-boot:run
```

3. Test endpoints using Postman or cURL

## 🧰 Built With

- Java 17 or higher
- Spring Boot 3.5.x
- Maven
- IntelliJ IDEA

---

## 📬 Feedback

Pull requests and stars welcome! 🙌
