FROM amazoncorretto:19-alpine-jdk
MAINTAINER gastonAlonso
COPY target/gastonAlonso-0.0.1-SNAPSHOT.jar gastonAlonso.jar
ENTRYPOINT ["java","-jar","/gastonAlonso.jar"]
