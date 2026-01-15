# E-Commerce Microservices Application

## 📌 Overview
This project is a backend **E-Commerce application** developed using **Java and Spring Boot** following the **Microservices architecture**.  
Each business capability is implemented as an independent service, and all services communicate with each other through REST APIs.

The project is created for **learning and understanding real-world microservices concepts** and backend development best practices.

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Cloud
  - Eureka Server (Service Discovery)
  - API Gateway
  - OpenFeign (Inter-service communication)
- Resilience4j (Circuit Breaker & Fault Tolerance)
- MySQL
- Maven
- REST APIs

---

## 🧩 Microservices in This Project
- **Service Registry (Eureka Server)**  
  Used for service discovery and registration.

- **API Gateway**  
  Acts as a single entry point for all client requests and routes requests to appropriate services.

- **Product Service**  
  Manages product-related operations such as creating and retrieving products.

- **Order Service**  
  Handles order creation and communicates with Product Service to fetch product details.

- **User Service**  
  Manages user-related operations.

---

## 🏗️ Architecture
The application follows a **microservices-based architecture**:

- All services register themselves with **Eureka Server**
- Services communicate using **OpenFeign**
- **API Gateway** routes all incoming requests
- **Resilience4j** is used for fault tolerance

(You can add an architecture diagram image here later)

---

## 🚀 How to Run the Application
Follow the below order to run the system:

1. Start **Eureka Server**
2. Start **API Gateway**
3. Start **Product Service**
4. Start **Order Service**
5. Start **User Service**

Each service runs independently on its configured port.

---

## ✨ Features Implemented
- Microservices architecture
- Service discovery using Eureka
- API Gateway routing
- Inter-service communication using OpenFeign
- Circuit breaker implementation using Resilience4j
- RESTful APIs
- MySQL database integration

---

## 🎯 Learning Outcome
Through this project, I gained hands-on experience in:
- Designing microservices-based systems
- Spring Boot REST API development
- Service-to-service communication
- Handling failures using circuit breakers
- Backend system design concepts

---

## 📌 Future Enhancements
- Add Spring Security with JWT authentication
- Integrate frontend using React
- Add centralized configuration server
- Dockerize services
