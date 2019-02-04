FROM openjdk:alpine
ARG version=0.0.1-SNAPSHOT
RUN ls
COPY target/itenerary-search-${version}.jar /itenerary-search.jar
ENV JAVA_OPTS ""
ENTRYPOINT mvn clean install
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /itenerary-search.jar
EXPOSE 8091