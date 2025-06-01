FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/weatherly-jpro-1.0-SNAPSHOT.jar app.jar

# Download and unpack JavaFX SDK (adjust version as needed)
RUN apt-get update && apt-get install -y wget unzip \
    && wget https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_linux-x64_bin-sdk.zip \
    && unzip openjfx-21.0.2_linux-x64_bin-sdk.zip \
    && rm openjfx-21.0.2_linux-x64_bin-sdk.zip

EXPOSE 8080

CMD ["java", "--module-path", "/app/javafx-sdk-21.0.2/lib", "--add-modules", "ALL-MODULE-PATH", "-Djpro.startpage=one.jpro.hellojpro.App", "-jar", "app.jar"]
