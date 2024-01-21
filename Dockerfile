FROM openjdk:8 AS BUILD_IMAGE
RUN apt update && apt install maven -y
RUN git clone https://github.com/snoman786/ui_backend.git
RUN cd ui_backend && git checkout master && mvn install

FROM openjdk:8
RUN mkdir /app
COPY --from=BUILD_IMAGE  ui_backend/target/ui_backend-0.0.1-SNAPSHOT.jar /app/ui_backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/app/ui_backend.jar"]