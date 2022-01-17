FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/eterrain-app.jar
ENTRYPOINT ["java","-jar","/eterrain-app.jar"]
