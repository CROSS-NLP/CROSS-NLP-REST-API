FROM maven:3.8.6-openjdk-8
RUN git clone https://github.com/CROSS-NLP/CROSS-NLP-REST-API.git
WORKDIR CROSS-NLP-REST-API/cross-nlp-rest-api/
RUN mvn -N io.takari:maven:wrapper
RUN mvn package
RUN mkdir /APP \
&& cp target/CROSS-NLP-REST-API.jar /APP \
&& rm -r /CROSS-NLP-REST-API/*
ENTRYPOINT ["java", "-jar", "/APP/CROSS-NLP-REST-API.jar"]
