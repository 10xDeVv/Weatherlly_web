FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .

RUN mvn clean package

FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/weatherly-jpro-1.0-SNAPSHOT-shaded.jar app.jar

EXPOSE 8080

# Launch using JPro's built-in runner
CMD ["java", "-Djpro.startpage=one.jpro.hellojpro.App", "-jar", "app.jar"]
