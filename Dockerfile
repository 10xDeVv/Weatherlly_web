FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean package

# Use Liberica Full JDK (with JavaFX) for runtime
FROM bellsoft/liberica-openjdk-debian:latest

WORKDIR /app
COPY --from=build /app/target/weatherly-jpro-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-Djpro.startpage=one.jpro.hellojpro.App", "-jar", "app.jar"]
