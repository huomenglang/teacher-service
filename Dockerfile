FROM openjdk:21 AS build

WORKDIR /app

COPY build/libs/teacher-1.0.0.jar teacher-1.0.0.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "teacher-1.0.0.jar"]