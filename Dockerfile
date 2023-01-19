FROM amazoncorretto:19-alpine-jdk
MAINTAINER gaston-alonso
COPY target/gastonAlonso-0.0.1-SNAPSHOT.jar  app.jar
ENTRYPOINT ["java","-jar","/app.jar"]