FROM amazoncorretto:11-alpine-jdk
MAINTAINER gastonAlonso
COPY target/gastonAlonso-0.0.1-SNAPSHOT.jar  GA-app.jar
ENTRYPOINT ["java","-jar","/GA-app.jar"]