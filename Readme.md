## Spring web service of a CRUD of bookmarker using Spring JPA, Spring MVC and Spring Boot, including GET, PUT, POST and DELETE operations for a bookmarker entity.

## Requirements

1. Java - 1.8.x
2. Maven - 3.x.x
3. Mysql - 5.x.x

##How to run

1. Clone the repository.

https://github.com/HarishForJava/HFJ-BookMarker-SpringBoot-msql-restApi.git

2. Create the database "test" in MySQL.

mysql -u root -p

mysql> create database book_marker;

3. Change mysql username and password as per your installation

   open src/main/resources/application.properties.

   change spring.datasource.username and spring.datasource.password as per your MySQL installation.
   
4. start the Application.   

The app will start running at http://localhost:8080.

## Explore Rest APIs

The app defines following CRUD APIs.

## 1. POST http://localhost:8080/api/bookmarker
Create data
###sample Request
{
	"title":"Git-Hub",
	"content":"www.github.com/HarishForJava"
}


## 2.GET http://localhost:8080/api/bookmarkers

## 3.GET http://localhost:8080/api/bookmarker/{id}

## 4.PUT http://localhost:8080/api/bookmarkers/{id}
update data
###sample Request
{
	"title":"Git-Hub",
	"content":"www.github.com/"
}

## 5.DELETE http://localhost:8080/api/bookmarkers/{id}

You can test them using postman or any other rest client.

