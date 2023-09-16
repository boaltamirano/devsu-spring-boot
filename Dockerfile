FROM openjdk:17
COPY target/omar-0.0.1-SNAPSHOT.jar /app/omar-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "omar-0.0.1-SNAPSHOT.jar"]
