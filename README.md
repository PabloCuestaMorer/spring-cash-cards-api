# Family Cash Card

**Table of Contents**
- [Getting Started](#getting-started)
- [Testing](#testing)
- [Keywords](#keywords)
- [Author](#author)

This is a simple Spring Boot application that allows parents to manage allowance funds for their children. The application uses a RESTful API to allow parents to create, edit, delete, and view cash cards. The application is also secured with Spring Security to protect it from unauthorized access.

The goal of the project was to learn how to use Spring Boot to build a RESTful API.

- Spring Data
- Spring Security

The project is well-documented and includes unit tests.

Keywords: Spring Boot, RESTful API, Spring Data, Spring Security, allowance, family, kids

## Getting Started

To get started with the Family Cash Card app, follow these steps:

1. **Clone the Repository**: Start by cloning this repository to your local machine using Git:
      ```bash
      git clone https://github.com/your-username/family-cash-card.git
      ```

2. **Build the Application**: Navigate to the project's root directory and build the application using Gradle:
      ```
      cd family-cash-card
      ./gradlew build
      ```
   
3.  **Run the Application**: After a successful build, you can run the application using the following command:
      ```
      ../gradlew bootRun
      ```

4.  **Access the Application**: Once the application is running, you can access it in your web browser or through API clients at http://localhost:8080. You will find comprehensive API documentation and endpoints for managing cash cards for your family.

## Testing
Unit tests have been included in the project to ensure the reliability and correctness of the application. You can run these tests using Gradle:

```
./gradlew test
```

## Keywords
- Spring Boot
- RESTful API
- Spring Data
- Spring Security
- Allowance
- Family
- Kids

## Author
This project is maintained by [Pablo Cuesta Morer](https://github.com/PabloCuestaMorer).
