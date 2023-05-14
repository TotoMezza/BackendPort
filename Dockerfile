FROM amazoncorretto:17
MAINTAINER TomasMezza
COPY  target/tm-0.0.1-SNAPSHOT.jar tm-deploy.jar
ENTRYPOINT  ["java","-jar","/tm-deploy.jar"]