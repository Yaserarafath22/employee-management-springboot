# Employee Management System

A REST API built with **Spring Boot** to manage employee records with full CRUD operations, backed by a MySQL database.

## Features

- Create, read, update and delete employee records
- MySQL database with auto-incrementing IDs
- Input validation (returns `400` for bad requests)
- Proper `404` response for non-existent IDs

## Tech Stack

- **Language / Framework:** Java, Spring Boot
- **Database:** MySQL
- **Build Tool:** Maven

## Getting Started

### Prerequisites

- Java 17+
- Maven
- MySQL 8+

### Installation

```bash
git clone https://github.com/Yaserarafath22/employee-management-springboot.git
cd employee-management-springboot
```

### Database Setup

```sql
CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employees (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100),
  salary DECIMAL(10,2)
);
```

Update your MySQL username and password in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
server.port=8081
```

### Run

```bash
mvn spring-boot:run
```

Server runs at `http://localhost:8081`

## API Endpoints

| Method | Endpoint           | Description              |
|--------|--------------------|--------------------------|
| GET    | `/employees`       | Get all employees        |
| GET    | `/employees/{id}`  | Get an employee by ID    |
| POST   | `/employees`       | Add a new employee       |
| PUT    | `/employees/{id}`  | Update an employee       |
| DELETE | `/employees/{id}`  | Delete an employee       |

### Example Request

`POST /employees`

```json
{
  "name": "Raj",
  "email": "raj@gmail.com",
  "salary": 50000
}
```

### Example Response

```json
{
  "id": 1,
  "name": "Raj",
  "email": "raj@gmail.com",
  "salary": 50000
}
```

## Status Codes

| Code | Meaning                |
|------|------------------------|
| 200  | Success                |
| 201  | Created                |
| 400  | Invalid input          |
| 404  | Employee not found     |
| 500  | Server error           |

## Future Improvements

- Search employees by name
- Simple HTML frontend
- Pagination

## Author

[GitHub: Yaserarafath22](https://github.com/Yaserarafath22)
