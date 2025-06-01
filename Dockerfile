FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package

FROM eclipse-temurin:21-jre
WORKDIR /app

# Install JavaFX native dependencies and tools
RUN apt-get update && apt-get install -y \
    libx11-6 libxrender1 libxtst6 libxi6 libglib2.0-0 libgtk-3-0 libasound2t64 wget unzip \
    && rm -rf /var/lib/apt/lists/*

COPY --from=build /app/target/weatherly-jpro-1.0-SNAPSHOT.jar app.jar

# Download and unpack JavaFX SDK (adjust version as needed)
RUN wget https://download2.gluonhq.com/openjfx/21.0.2/openjfx-21.0.2_linux-x64_bin-sdk.zip \
    && unzip openjfx-21.0.2_linux-x64_bin-sdk.zip \
    && rm openjfx-21.0.2_linux-x64_bin-sdk.zip

EXPOSE 8080

ENV LD_LIBRARY_PATH="/app/javafx-sdk-21.0.2/lib"

CMD ["java", "--module-path", "/app/javafx-sdk-21.0.2/lib", "--add-modules", "ALL-MODULE-PATH", "-Djava.library.path=/app/javafx-sdk-21.0.2/lib", "-Djpro.startpage=one.jpro.hellojpro.App", "-jar", "app.jar"]
