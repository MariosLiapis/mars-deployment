# Use lightweight Java runtime as base
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

EXPOSE 8080


# Copy the built JAR file into the container

COPY target/mars-deployment-0.0.1-SNAPSHOT.jar app.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
