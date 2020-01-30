# CROSS NLP REST API : README  #
A REST API featuring a collection of Natural Language Processing tools for the software engineering domain.


## Prerequisites ##

Please ensure that the following are installed on your system and docker is running before following the steps defined below.

	- Maven
	- JDK 8
	- Docker (docker requires at least 6gb of memory) 
	- Git

## Configuration (application.properties) ##

The `application.properties` file located in `src/main/resources` enables you to configure numerous properties of the REST API. 

- **server.address** : allows you to specify the server address you want the REST API to be bound to. At default server address is `0.0.0.0` (`localhost`).

- **server.port** : allows you to specify the port you want you would like the API to be accesed through. The default value is `8080`.

Full details of all the application properties can be found <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html" target="_blank">here</a>

## Build Steps: ##

**1.** Open terminal, navigate to your chosen directory and clone the NLP-TOOLS_REST_API Repository using:

	git clone https://github.com/Danny2097/CROSS-NLP-REST-API.git

**2**. Open terminal and navigate to the `cross-nlp-rest-api` directory. 

**3.** Once inside the directory, run the following command 

	mvn -N io.takari:maven:wrapper

This ensures that the Maven build has everything necessary to run (and you dont need to install mutliple versions of Maven).

**4.** Next we need to build the `CROSS-NLP-REST-API.jar`. To do this run <u>one</u> of the following commands:

	For UNIX based systems run    :      	./mvnw install
	For Windows based systems run : 	mvnw.cmd install

### Deployment Options ###

The REST API can be deployed using as a runnable Jar or via Docker. See below for instructions. 

**Runnable Jar** (this needs modification)

**1.**To run the REST API using the `jar` navigate to the `target` directory and run the following command :

```
java -jar CROSS-NLP-REST-API.jar
```

**Docker** (this needs modification)

**1.** Whilst inside the `cross-nlp-rest-api` directory, Run the following command to build a image 

	docker build -t cross-nlp-rest-api .

**2.** To run the container enter the following command: 

	docker run -p <Port>:8080 -t cross-nlp-rest-api --name cross-nlp-rest-api

Replacing  `<Port>` with the port number you would like the container to be accessible on. For example if you want to access the container using via port `2097` then you would run :

	docker run -p 2097:8080 cross-nlp-rest-api --cross-nlp-rest-api


## Landing Page ##

CROSS NLP REST API has a built in landing page with a bunch of information relating to the API. It can be accessed via `<server-address>:<port-number>`. For example (using the default configuration) `http://localhost:8080/`.

## Documentation ##

Once deployed the REST API also includes documentation in two forms. 

**Swagger (OpenAPI)** : balboa.

This can be accessed via `<server-address>:<port-number>/v2/api-docs`. 

For example (using the default configuration) :

```
http://localhost:8080/v2/api-docs
```



**Swagger UI**: Best for developers and users of the REST API. This includes all documentation for each end point and models. You can also run some examples to test the endpoints. This can be accessed via `<server-address>:<port-number>/swagger-ui.html`. 

For example (using the default configuration) :

	http://localhost:8080/swagger-ui.html


