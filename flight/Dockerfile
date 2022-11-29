FROM openjdk:8-jdk-alpine

LABEL image.author="zaid.hamasha@gmail.com"

WORKDIR /opt

COPY --chown=nobody:nobody   ./target/flight*.jar   /opt/flight-service.jar

EXPOSE 8060

ENTRYPOINT ["java","-jar","/opt/flight-service.jar"]