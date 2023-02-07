FROM openjdk:17
EXPOSE 8090
ADD target/bootcoin-microservice-0.0.1-SNAPSHOT.jar bootcoin-microservice.jar
ENTRYPOINT ["java","-jar","/bootcoin-microservice.jar"]