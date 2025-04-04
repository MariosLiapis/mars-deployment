# Mars Deployment - CI/CD Space Resource Manager

## Overview

This is a Spring Boot CRUD application project, called "mars-deployment" designed to manage space station resources for a Mars Deployment mission. It includes a complete CI/CD pipeline using GitHub Actions, supports Dockerization, and enforces code quality checks. It is the first Lab Assignment of the "Software Engineering in Practice" course at the Department of Management Science and Technology, Athens University of Economics and Business.

## Purpose

The purpose of this project is to demonstrate a complete CI/CD pipeline by developing a simple CRUD-based backend application for managing space station resource inventory. It is built with Java and Spring Boot, it supports RESTful interactions and runs on an in-memory H2 database. It is fully containerized with Docker and intefrated with GitHub Actions to automate building, testing, code quality checks and Docker image deployment. 

## Application Details

- **Framework**: Java 21, Spring Boot 3.4.3
- **Embedded Database**: H2 (in-memory)
- **Build Tool**: Maven
- **Testing**: JUnit 5
- **Static Analysis**: PMD, Checkstyle
- **Test Coverage**: JaCoCo
- **CI/CD**: GitHub Actions
- **Containerization**: Docker, Docker Hub

## Running Locally

1. Clone the repository: git clone https://github.com/mariosliapis/mars-deployment.git
2. Build the project: mvn clean package
3. Run the application: java -jar target/mars-deployment-0.0.1-SNAPSHOT.jar
4. Access the app at: http://localhost:8080/resources

## Running with Docker

1. Build the Docker image: docker build -t mars-deployment .
2. Run the container: docker run -p 8080:8080 mars-deployment
3. Access the application at: http://localhost:8080/resources 
