FROM java:8
ADD target/eterrain-app.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","app.jar"]