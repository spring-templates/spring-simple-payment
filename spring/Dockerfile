# syntax=docker/dockerfile:latest
# Run the application
FROM bellsoft/liberica-openjre-alpine:21 AS runner
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
