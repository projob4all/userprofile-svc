FROM openjdk:11
ARG JAR_FILE
COPY ${JAR_FILE} userprofile-svc.jar
ENTRYPOINT ["java", "-jar", "/userprofile-svc.jar"]
