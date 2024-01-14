FROM openjdk:11

WORKDIR /app

COPY build/libs/spring-0.0.1-SNAPSHOT-boot.jar /app/spring.jar

ENTRYPOINT ["java", "-jar", "spring.jar"]