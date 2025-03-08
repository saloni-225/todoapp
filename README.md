# Todo Application

## Features
- **Task Management** (Add, Edit, Delete, Mark as Completed)
- **User Authentication and Authorization**
- **Due Date and Priority Management**
- **Search and Filter Tasks**
- **Email Reminders for Due Tasks**
- **Task Category Management**

## Technology Stack
- **Spring Boot** - Core Framework
- **H2 Database** - In-Memory Database
- **JPA/Hibernate** - ORM
- **Maven** - Build Automation
- **Thymeleaf** - Front-end Templating
- **Spring Security** - Authentication and Authorization
- **Quartz Scheduler** - Email Reminders

## Getting Started

### Prerequisites
Ensure you have the following installed:
- **Java 17 or higher**
- **Maven**
- **IDE** - IntelliJ, Eclipse, or VSCode

### Installation
1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd todo-application
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Usage
- Access the application at `http://localhost:8080`
- Register as a new user or log in with your credentials
- Start managing your tasks efficiently

