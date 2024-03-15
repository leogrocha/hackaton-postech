FROM openjdk:17-slim

ENV DOCKERIZE_VERSION v0.6.1

RUN apt-get update && apt-get install -y wget maven \
    && wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

WORKDIR /app

COPY . /app

RUN mvn clean install -DskipTests

RUN mv target/postech-0.0.1-SNAPSHOT.jar app.jar && rm -rf target

EXPOSE 8080

ENTRYPOINT ["dockerize", "-wait", "tcp://mysql-db:3306", "-timeout", "30s", "java", "-jar", "app.jar"]
