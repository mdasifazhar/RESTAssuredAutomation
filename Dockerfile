FROM maven:3.6.3-jdk-11
COPY src home/apiframework/src
COPY pom.xml home/apiframework
COPY testng.xml home/apiframework
COPY Dockerfile home/apiframework
WORKDIR home/apiframework
ENTRYPOINT mvn clean test