FROM openjdk:8
ADD target/grades_ms-0.0.1-SNAPSHOT.jar grades_ms-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD mvn clean package
ENTRYPOINT ["java", "-jar", "grades_ms-0.0.1-SNAPSHOT.jar"]