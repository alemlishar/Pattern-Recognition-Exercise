FROM openjdk:8-jdk-alpine
MAINTAINER welld.com
COPY target/Exercise-0.0.1-SNAPSHOT.jar Pattern-Recognition-Exercise-0.0.1.jar
ENTRYPOINT ["java","-jar","/Pattern-Recognition-Exercise-0.0.1.jar"]