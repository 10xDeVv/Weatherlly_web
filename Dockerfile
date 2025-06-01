FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "target/weatherly-jpro-1.0-SNAPSHOT.jar.jar"]
