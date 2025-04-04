# Build stage
FROM maven:3.9.9-openjdk-21 AS Build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

# Runtime stage

# Use lightweight Java runtime as base
FROM openjdk:21-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file into the container

COPY --from=Build /app/target/*.jar app.jar

EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
