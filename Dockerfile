FROM openjdk:8-jdk-slim
RUN mkdir -p /usr/share/man/man1 \
    && apt-get update \
    && apt-get install -y maven git \
    && apt-get clean \
    && apt-get autoremove
RUN git clone https://github.com/CROSS-NLP/CROSS-NLP-REST-API.git
WORKDIR CROSS-NLP-REST-API/cross-nlp-rest-api/
RUN mvn -N io.takari:maven:wrapper \
    && ./mvnw install \
    && rm target/CROSS-NLP-REST-API.jar.original
ENTRYPOINT ["java", "-jar", "/CROSS-NLP-REST-API/cross-nlp-rest-api/target/CROSS-NLP-REST-API.jar"]
