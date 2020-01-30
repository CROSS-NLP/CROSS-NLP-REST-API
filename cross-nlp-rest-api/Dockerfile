FROM openjdk:8-jre-slim
VOLUME /tmp
ARG JAR_FILE
COPY /target/CROSS-NLP-REST-API.jar CROSS-NLP-REST-API.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","CROSS-NLP-REST-API.jar"]

