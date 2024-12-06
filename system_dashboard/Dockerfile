FROM amazoncorretto:17
ENV TZ=America/Los_Angeles
WORKDIR /app
COPY ./target/system_dashboard-0.0.1-SNAPSHOT.jar /app
COPY ./src/main/resources/airDevices.json /app/airDevices.json
EXPOSE 8080
CMD ["java", "-jar", "system_dashboard-0.0.1-SNAPSHOT.jar"]
