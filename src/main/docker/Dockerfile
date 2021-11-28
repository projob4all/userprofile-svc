FROM adoptopenjdk/openjdk11:latest
#VOLUME /tmp
#ARG JAR_FILE
#ADD ${JAR_FILE} ${JAR_FILE}
ADD build/libs/*.jar userprofile-svc.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","userprofile-svc.jar" ]