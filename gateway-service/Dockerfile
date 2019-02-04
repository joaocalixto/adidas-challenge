FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
RUN ls
COPY target/gateway-service-${version}.jar /gateway-service.jar
ENV JAVA_OPTS ""
ENTRYPOINT mvn clean install
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /gateway-service.jar
EXPOSE 8001