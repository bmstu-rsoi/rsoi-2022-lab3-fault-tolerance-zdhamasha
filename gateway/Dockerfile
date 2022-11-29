FROM openjdk:8-jdk-alpine

LABEL image.author="zaid.hamasha@gmail.com"

WORKDIR /opt

COPY --chown=nobody:nobody   ./target/gateway*.jar   /opt/gateway-service.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/opt/gateway-service.jar"]