# syntax=docker/dockerfile:latest
# Run the application
FROM bellsoft/liberica-openjre-alpine:21 AS runner
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
