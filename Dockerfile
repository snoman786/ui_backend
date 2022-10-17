FROM openjdk:8
ADD target/ui_backend-0.0.1-SNAPSHOT.jar ui_backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/ui_backend.jar"]