FROM openjdk:8-jdk-alpine

LABEL image.author="zaid.hamasha@gmail.com"

WORKDIR /opt

COPY --chown=nobody:nobody   ./target/bonus*.jar   /opt/bonus-service.jar

EXPOSE 8050

ENTRYPOINT ["java","-jar","/opt/bonus-service.jar"]