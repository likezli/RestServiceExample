# RestServiceExample

## RESTful-Service example based on Java/JavaEE

This example shows how to read open data from an external [web resource](https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am "SFOpen Data") and display these in JSON format.

## Technologies used

- Maven 3.3.9 (Build tool)
- Java 1.8 
- Jersey 1.19 (JAX-RS)
- Jackson 2.8.1 (JSON library)
- Tomcat 8.5 (Server)

## How To

- clone project from git repository

```
git clone https://github.com/likezli/RestServiceExample.git
```

- build project with maven
```
mvn install
```

- deploy .war file to tomcat server and start server

## Rest Services Resources

Following GET request will return "Hello World!" in plain text
```
http://localhost:8080/RestServiceExample/rest/test/hello
```

Following GET request will return some samples in JSON format
```
http://localhost:8080/RestServiceExample/rest/test/samples
```

Following GET request will return open data from SFOpen data web resource in JSON format
```
http://localhost:8080/RestServiceExample/rest/test/getAllFilms
```
