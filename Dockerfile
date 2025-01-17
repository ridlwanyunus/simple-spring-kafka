FROM openjdk:17-jdk
ENV TZ=Asia/Jakarta
ARG TARGET_JAR=target/*.jar
COPY ${TARGET_JAR} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]