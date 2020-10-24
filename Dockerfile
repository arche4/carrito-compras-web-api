FROM openjdk:11-jdk-alpine
VOLUME /tmp
ADD target/carrito-compras-api-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

