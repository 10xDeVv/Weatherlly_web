# Stage 1: Use Maven with Java 21 to build the project
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

RUN mvn clean package

# Stage 2: Use minimal JDK to run the app
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/weatherly-jpro-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
