FROM openjdk:8-jre

COPY InfectionTestApp-*.jar /usr/src/app/app.jar
WORKDIR /usr/src/app
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]