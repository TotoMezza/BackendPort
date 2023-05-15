FROM amazoncorretto:17
COPY target/tm-0.0.1-SNAPSHOT.jar tm-app.jar
ENTRYPOINT ["java","-jar","/tm-app.jar"]
EXPOSE 8080
