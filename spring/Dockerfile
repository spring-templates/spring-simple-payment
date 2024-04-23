# syntax=docker/dockerfile:latest

# Stage 1: Make the base image
FROM bellsoft/liberica-openjdk-alpine:21 AS base
LABEL maintainer="ooMia"
RUN apk add dos2unix

# Stage 2: Build the application
FROM base AS builder
LABEL maintainer="ooMia"
COPY . .
WORKDIR /spring
RUN ls -la
RUN dos2unix gradlew
RUN sh gradlew build -x test --parallel

# Stage 3: Run the application
FROM bellsoft/liberica-openjre-alpine:21 AS runner
COPY --from=builder /spring/build/libs/*-SNAPSHOT.jar app.jar
HEALTHCHECK --interval=30s --timeout=3s --start-period=30s --retries=3 CMD wget -qO- http://localhost:8080/actuator/health || exit 1
ENTRYPOINT ["java", "-jar", "app.jar"]
