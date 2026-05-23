# CodeHub

CodeHub is a coding interview preparation platform currently being built using Spring Boot, MySQL, JWT Authentication, React, Docker, and AWS.

The goal of this project is to learn and implement production-level backend and full-stack development concepts step by step.

---

## Features Implemented

### Authentication & Security
- User Registration API
- User Login API
- BCrypt Password Hashing
- JWT Token Generation
- JWT Authentication Filter
- Protected API Routes using Spring Security

---

### Backend Architecture
- Layered Architecture
  - Controller Layer
  - Service Layer
  - Repository Layer
  - DTO Layer
- REST API Development
- Global Exception Handling
- Input Validation
- Clean Project Structure

---

### Database Integration
- MySQL Integration
- Spring Data JPA
- Hibernate ORM
- Automatic Table Creation

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL

### Authentication
- JWT
- BCrypt

### Tools
- Git
- GitHub
- Postman

---

## Project Structure

```bash
src/main/java/com/sravan/codehub
│
├── controller
├── service
├── repository
├── model
├── dto
├── security
├── exception
└── config
```

---

## Authentication Flow

```text
User Login
    ↓
Credentials Verification
    ↓
JWT Token Generation
    ↓
Frontend Stores Token
    ↓
Token Sent in Authorization Header
    ↓
JWT Filter Validates Token
    ↓
Protected APIs Accessible
```

---

## APIs Implemented

| Method | Endpoint | Description |
|---|---|---|
| POST | `/auth/register` | Register new user |
| POST | `/auth/login` | Login user and generate JWT token |

---

## Completed Features

- [x] Spring Boot Setup
- [x] MySQL Configuration
- [x] User Entity
- [x] Repository Layer
- [x] DTO Layer
- [x] Service Layer
- [x] REST Controllers
- [x] Validation
- [x] Global Exception Handling
- [x] Spring Security Configuration
- [x] BCrypt Password Hashing
- [x] JWT Authentication
- [x] JWT Filter
- [x] Protected Routes

---

## Planned Features

### Backend
- Problem Management Module
- Submission System
- Progress Tracking
- Leaderboard System
- Role-Based Authorization
- Redis Caching
- API Rate Limiting
- Async Processing
- Logging & Monitoring

### Frontend
- React Frontend
- Authentication Pages
- Dashboard
- Problem Solving Interface
- Leaderboard UI
- User Progress Analytics

### DevOps & Deployment
- Docker
- Docker Compose
- AWS Deployment
- CI/CD Pipeline
- Kubernetes (Future Enhancement)

---

## Concepts Practiced

- REST APIs
- Layered Architecture
- DTO Pattern
- Dependency Injection
- ORM (Object Relational Mapping)
- JWT Authentication
- Spring Security
- Exception Handling
- Input Validation
- Secure Password Storage

---

## Future Goal

The aim of this project is to build a scalable and production-style coding platform while learning backend engineering, system design concepts, cloud deployment, and DevOps practices.

---

## Author

Sravan
