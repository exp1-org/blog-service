FROM gradle:7.6.1 AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle build

FROM openjdk:11
ENV JAR_NAME=blog-service-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8082
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME