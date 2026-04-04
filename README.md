# Finance Dashboard Backend

## Overview
This project is a backend system for a finance dashboard built using Spring Boot. It provides APIs to manage financial records and generate summary-level insights such as income, expenses, and category-wise breakdowns.

The system follows a layered architecture and implements role-based access control to restrict operations based on user roles.

---

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Lombok

---

## Features

### 1. Financial Record Management
- Create financial records (Admin only)
- Retrieve all records
- Delete records (Admin only)
- Filter records by type (INCOME / EXPENSE)

### 2. Dashboard Analytics
- Total income
- Total expenses
- Net balance calculation
- Category-wise aggregation

### 3. Role-Based Access Control
- ADMIN: Full access (create, delete, view)
- ANALYST: View records and dashboard
- VIEWER: Read-only access

Role validation is implemented at the service layer.

### 4. DTO-Based Responses
- Clean API responses using DTOs
- Internal entity structure is not exposed

---

## API Endpoints

### Records

- Create Record  
  `POST /records?role=ADMIN`

- Get All Records  
  `GET /records`

- Delete Record  
  `DELETE /records/{id}?role=ADMIN`

- Filter Records by Type  
  `GET /records/filter?type=INCOME`

---

### Dashboard

- Summary (Income, Expense, Net)  
  `GET /dashboard/summary`

- Category-wise Summary  
  `GET /dashboard/categories`

---

## Project Structure
com.finance.dashboard
├── controller # REST Controllers
├── service # Business Logic
├── repository # Data Access Layer
├── entity # Database Entities
│ └── enums # Enum Classes
├── dto # Data Transfer Objects
├── config # Configuration
└── security # Security Setup


---

## Setup Instructions

1. Clone the repository

2. Create MySQL database:
   ```sql
   CREATE DATABASE finance_db;



---

## Setup Instructions

1. Clone the repository

2. Create MySQL database:
   ```sql
   CREATE DATABASE finance_db;

3. Configure database in application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

4. Build and run the application:

    mvn spring-boot:run

#### Sample Request
#### Create Record

    POST /records?role=ADMIN
    
    Request Body:
      
    {
    "amount": 1000,
    "type": "INCOME",
    "category": "Salary",
    "date": "2025-04-01",
    "notes": "Monthly salary"
    }