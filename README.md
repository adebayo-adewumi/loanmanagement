## About Loan Management App

Loan Management is a web application for disbursing fast loans.

## Installation Requirements
- BellSoft Liberica JDK version 17
- PostgresSQL
- Gradle
- IDE: IntelliJ iDea or VSCode

## Steps to run the Application
- Clone the repo to any location on your PC i.e git clone https://github.com/adebayo-adewumi/loanmanagement.git
- Open the project with you desired IDE
- Run the application.
- DB migration files are in src/main/db/migraion folder

### Implementation Details
- Database Migration using Flyway
- Swagger API Doc
- Unit Test and Mocking (JUNIT & Mockito)
- Healthcheck
- JWT Authentication
- Rate Limiting
- Audit & Error Logging

### Design Decision
This application was built using Spring Boot Modulith approach. 
The Modulith approach makes the code to be well-structured and in finding and working with application modules driven by the domain. It supports integration testing of individual modules, observing the application’s behavior on the module level and creating documentation snippets based on the arrangement created.

### Pros
- Readability
- Separation of concerns 
- Ease of collaboration.
- Little or No merge conflict

### Cons
- More code will be written

