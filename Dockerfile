# Dockerfile for Java Maven Project
FROM maven:3.8.4-openjdk-11 AS maven-build

WORKDIR /app

COPY . .

ENV FLASK_API_URL=http://host.docker.internal:5000

RUN mvn clean package

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=maven-build /app/target/cucumber-bdd-1.0-SNAPSHOT.jar /app/cucumber-bdd.jar

CMD ["java", "-jar", "cucumber-bdd.jar"]
