# Home Services Booking API

A REST API built using Java 17, Spring Boot, Spring Data JPA, and MySQL. The application allows clients to browse home services, search by name, view service details, and create and manage bookings.

## Features

- List all available home services.
- Search services by name.
- Retrieve service details by ID.
- Create bookings with input validation.
- View saved bookings.
- Return clear validation and not-found errors.
- Cancel pending bookings.
- Explore endpoints using Swagger UI.

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Bean Validation
- Maven
- JUnit 5 and Mockito
- Springdoc OpenAPI / Swagger UI

## Prerequisites

- JDK 17 or newer
- MySQL Server
- Maven or the included Maven Wrapper

## Database Setup

Create the database in MySQL:

```sql
CREATE DATABASE home_services_db;
```

Configure the following environment variables:

- `DB_USERNAME`: Your MySQL username.
- `DB_PASSWORD`: Your MySQL password.

The application connects to `localhost:3306/home_services_db`.

## Run the Application

1. Clone the repository.
2. Configure your MySQL credentials.
3. Run the application from your IDE, or execute:

On Linux/macOS:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The API runs at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/services` | List services |
| GET | `/api/services?search=clean` | Search services |
| GET | `/api/services/{id}` | Get service details |
| POST | `/api/bookings` | Create a booking |
| GET | `/api/bookings` | List bookings |
| PATCH | `/api/bookings/{id}/cancel` | Cancel a pending booking |

## Swagger Documentation

After starting the application, open:

`http://localhost:8080/swagger-ui/index.html`

## Run Tests

Linux/macOS:

```bash
./mvnw test
```

Windows:

```powershell
.\mvnw.cmd test
```

## Notes

- At least eight sample services are initialized when the service table is empty.
- New bookings start with `PENDING` status.
- Request validation enforces required fields, a ten-digit phone number, and a date that is not in the past.
- The current evaluation version does not implement customer authentication, so the bookings endpoint returns all saved bookings.

## Author

Omkar Ghunake
