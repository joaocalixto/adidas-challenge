FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
RUN ls
COPY target/itineraries-data-${version}.jar /itineraries-data.jar
ENV JAVA_OPTS ""
ENTRYPOINT mvn clean install
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /itineraries-data.jar
EXPOSE 8090