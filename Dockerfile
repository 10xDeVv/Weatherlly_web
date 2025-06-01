FROM bellsoft/liberica-runtime-container:21

# Install any needed libraries for JavaFX
RUN apt-get update && \
    apt-get install -y xorg libgtk-3-0 libasound2 libgl1-mesa-glx libfreetype6 fonts-dejavu

WORKDIR /app

# Copy your Maven project
COPY . /app

# Build your app (creates target/*.jar)
RUN ./mvnw clean package -DskipTests

# Expose the port (Heroku will set $PORT)
EXPOSE 8080

# Start the app, using the port Heroku provides
CMD ["sh", "-c", "java -jar target/weatherly-jpro-1.0-SNAPSHOT-shaded.jar -Dhttp.port=$PORT"]
