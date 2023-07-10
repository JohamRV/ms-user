FROM openjdk:11
ARG JAR_FILE=target/*.jar
EXPOSE 8085
COPY ${JAR_FILE} ms-user.jar
ENTRYPOINT ["java","-jar","/ms-user.jar"]
