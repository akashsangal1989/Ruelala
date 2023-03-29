FROM openjdk:11
MAINTAINER akash
RUN apt-get update
RUN apt-get install -y maven
COPY pom.xml /usr/local/services/pom.xml
COPY testng.xml /usr/local/services/testng.xml
COPY src /usr/local/services/src
WORKDIR /usr/local/services/

RUN mvn -Dapplicationurl=https://www.ruelala.com/boutique/ -Denvironment=stage  test