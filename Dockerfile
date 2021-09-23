FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} api-1.0.jar
EXPOSE 9000
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/api-1.0.jar"]


