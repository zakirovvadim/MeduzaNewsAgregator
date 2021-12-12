# Meduza News Agregator (MNA)
<p align="center"><img src="https://cdn-icons-png.flaticon.com/512/2540/2540832.png"
alt="Weather" height="300" />
  
  
 # Description
  This app use for getting news from Meduza.ru. The paltform which on based MNA is Java and Spring Boot.
  
  ## Development
- Development language: Java 8
- Framework: Spring Boot 2.5.5, Spring Data JPA, Spring Cloud OpenFeign, Spring Cloud Eureka
- Database: PostgreSQL v 10.19
- Libraries: Lombok, MapStruct
- API: Meduza News Api
- Build automation: Gradle
  
  ## The url to open the MNA
- Open the admin page for control another user role
  -  http://localhost:8080/admin
  
- Open the authorization page to MNA
  -  http://localhost:8080/auth/login
- Page for sign out from MNA account
  -  http://localhost:8080/auth/logout
  
- Open the main page
  -  http://localhost:8080/news/main
  
  ## How to launch
1. You have to launch Eureka server
2. Write the command inside your server.
 
console
    ./gradlew bootrun
3. After you need launch all services like database, back-end and front.
