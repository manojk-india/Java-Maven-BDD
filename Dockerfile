# Dockerfile for Java Maven Project
FROM maven:3.8.4-openjdk-11 AS maven-build

WORKDIR /app

COPY . .

ENV FLASK_API_URL=http://host.docker.internal:5000

RUN mvn clean package

CMD ["mvn","surefire:test"]