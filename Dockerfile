FROM openjdk:8-jdk-alpine
MAINTAINER welld.com
Expose 8088
COPY target/Pattern-Recognition-Exercise-0.0.1.jar Pattern-Recognition-Test-0.0.1.jar
ENTRYPOINT ["java","-jar","/Pattern-Recognition-Test-0.0.1.jar"]