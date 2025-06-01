FROM bellsoft/liberica-runtime-container:jdk-21-slim-glibc


WORKDIR /app

# Copy your Maven project
COPY . /app

# Build your app (creates target/*.jar)
RUN mvn clean package -DskipTests

# Expose the port (Heroku will set $PORT)
EXPOSE 8080

# Start the app, using the port Heroku provides
CMD ["sh", "-c", "java -jar target/weatherly-jpro-1.0-SNAPSHOT-shaded.jar -Dhttp.port=$PORT"]
