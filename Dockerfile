FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .
RUN mvn clean package


FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/weatherly-jpro-1.0-SNAPSHOT.jar app.jar

EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
