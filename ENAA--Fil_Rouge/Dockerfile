FROM openjdk:17
ADD target/*.jar appWs.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/appWs.jar"]
