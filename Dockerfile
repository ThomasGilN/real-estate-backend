FROM amazoncorretto:17-alpine-jdk
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
RUN ./gradle clean && build
ARG JAR_FILE=target/*.jar
ARG APP_FILE=real-estate-app.jar
COPY ${JAR_FILE} ${APP_FILE}
EXPOSE 8080
ENTRYPOINT ["java","-jar","/${APP_FILE}"]