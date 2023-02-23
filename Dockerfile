FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-info.jar
ENTRYPOINT ["java","-jar","/user-info.jar"]