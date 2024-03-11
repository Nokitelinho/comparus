# Spring Boot Rest API with multiple DB connections
Unit testing with Junit 5, Integration tests, Maven

## What You Need
- A favorite text editor or IDE
- Java 17 or later
- Maven 3.9.5
You can also import the code straight into your IDE:
- IntelliJ IDEA
<br><br>
Download and unzip the source repository or clone it using Git: <br>
``git clone https://github.com/Nokitelinho/comparus.git``

## Test the Application
Using the Maven plugin open project and from README click:<br>
``` mvn clean install ```
``` mvn spring-boot:run -pl business```
<br>OR<br>
run business/src/main/java/com/comparus/Application.java from IntelliJ IDEA
<br><br>
Now that the application is running, you can test it. You can load the home page at

http://localhost:8080/api/v1/users

You can see first 2 records from DB1 and second 2 records from DB2
```
[{
"id": "035670f0-5d53-4691-b72c-4f969a10edc6",
"username": "a-login-t1",
"name": "Andrew",
"surname": "Johnson"
},
{
"id": "035670f0-5d53-4691-b72c-4f969a10edc7",
"username": "m-login-t1",
"name": "Mike",
"surname": "Pearson"
},
{
"id": "035670f0-5d53-4691-b72c-4f969a10edc1",
"username": "b-login-t2",
"name": "Bob",
"surname": "Tompson"
},
{
"id": "035670f0-5d53-4691-b72c-4f969a10edc2",
"username": "j-login-t2",
"name": "Jack",
"surname": "Simpson"
}]
```

You can filter and sorting users by id, username, name, surname:<br>
http://localhost:8080/api/v1/search?name=Andr<br>
http://localhost:8080/api/v1/search?name=a-login<br>
http://localhost:8080/api/v1/search?surname=Jo<br>
<br>
Also sorting available by username, name, surname:<br>
http://localhost:8080/api/v1/users?sort=username&order=desc<br>
http://localhost:8080/api/v1/users?sort=username&order=asc<br>
http://localhost:8080/api/v1/users?sort=name&order=desc<br>
http://localhost:8080/api/v1/users?sort=name&order=asc<br>


## H2 in memory DB consol
http://localhost:8080/h2-console
- JDBC URL: jdbc:h2:mem:comparus
- User Name: sa
- JDBC URL: jdbc:h2:mem:comparus2
- USer Name: sa

## Swagger 3 UI(with OpenAPI 3)

http://localhost:8080/swagger-ui/index.html
