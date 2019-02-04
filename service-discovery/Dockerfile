FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
RUN ls
COPY target/service-discovery-${version}.jar /service-discovery.jar
ENV JAVA_OPTS ""
ENTRYPOINT mvn clean install
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /service-discovery.jar
EXPOSE 8761