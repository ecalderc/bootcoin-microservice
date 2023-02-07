FROM maven:3.8.5-openjdk-17-slim AS build
VOLUME /tmp
COPY .. ./
RUN mvn clean package -DskipTests

FROM openjdk:17
VOLUME /tmp
EXPOSE 8090
COPY --from=build /target/bootcoin-microservice-0.0.1-SNAPSHOT.jar ./bootcoin-microservice.jar
ENTRYPOINT ["java","-jar","/bootcoin-microservice.jar"]