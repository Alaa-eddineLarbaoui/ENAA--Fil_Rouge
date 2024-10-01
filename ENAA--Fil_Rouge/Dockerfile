FROM openjdk:17
COPY target/*.jar apps.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/apps.jar"]
