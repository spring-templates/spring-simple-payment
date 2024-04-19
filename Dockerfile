# syntax=docker/dockerfile:latest
# Stage 1: Build the application
FROM bellsoft/liberica-openjdk-alpine:21 AS builder
LABEL maintainer="ooMia"
COPY . .
CMD ["./gradlew", "build"]

# Stage 2: Run the application
FROM bellsoft/liberica-openjre-alpine:21 AS runner
COPY --from=builder build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
