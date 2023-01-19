FROM openjdk:19-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
MAINTAINER gastonAlonso
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
