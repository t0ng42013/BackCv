FROM amazoncorretto:19
MAINTAINER gastonAlonso
COPY target/gastonAlonso.jar  gastonAlonso.jar
ENTRYPOINT ["java", "-jar", "gastonAlonso.jar"]