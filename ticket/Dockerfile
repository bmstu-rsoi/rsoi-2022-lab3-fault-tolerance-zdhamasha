FROM openjdk:8-jdk-alpine

LABEL image.author="zaid.hamasha@gmail.com"

WORKDIR /opt

COPY --chown=nobody:nobody   ./target/ticket*.jar   /opt/ticket-service.jar

EXPOSE 8070

ENTRYPOINT ["java","-jar","/opt/ticket-service.jar"]