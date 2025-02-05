﻿# spring-test-Api

## User Management System

### Description

This project allows you to manage a set of users. It offers the following functionalities:

* **User Creation:** Add new users with their personal information.
* **Profile Modification:** Update existing user information.
* **User Deletion:** Permanently delete a user.

Additionally, the project includes automated tests such as:

* **Unit Tests:** Tests to verify the proper functioning of the Service classes.
* **Integration Tests:** Tests to verify actions on the database.
* **Controller Unit Tests:** Tests to verify the proper functioning of the Controller classes.
* **End-to-End Tests:** Tests to ensure that all parts and components of the application work together correctly.

### Prerequisites

Before you can install and run this project, make sure you have the following installed on your machine:

* [Java JDK 11+](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Docker](https://www.docker.com/products/docker-desktop)

### Installation

To install and run this project, follow these steps:

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-username/spring-test-Api.git
   cd spring-test-Api

2. **Start Docker:**
   docker compose -f src/main/docker/postgresql.yml up

3. **Run the application using Maven Wrapper:**

   ./mvnw spring-boot:run


### Usage

Once the application is running, it will be accessible via http://localhost:8080. You can use the following REST endpoints to interact with the application:

**Create a user:**
POST /api/users
Content-Type: application/json

{
  "name": "User's name",
  "email": "email@example.com",
  "password": "password123",
  "role": "User"
}

**Modify a user:**

PUT /api/user/{userName}
Content-Type: application/json

{
  "name": "Modified user's name",
  "email": "email-modified@example.com",
  "password": "newpassword123",
  "role": "Admin"
}

**Delete a user:**

DELETE /api/users/{userName}


### Tests

The project includes various types of automated tests:

   **Unit Tests :** To verify the proper functioning of the Service classes.
   
   **Integration Tests :** To verify actions on the database.
   
   **Controller Unit Tests :** To verify the proper functioning of the Controller classes.
   
   **End-to-End Tests :** To ensure that all parts and components of the application work together correctly.

To run the tests, use the following command:

./mvnw test

