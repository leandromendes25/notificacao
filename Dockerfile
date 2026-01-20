from gradle:jdk21 as build
WORKDIR /app
COPY . .
run gradle build --no-daemon #daemon acelera o build


FROM eclipse-temurin:21-jre
WORKDIR /app

COPY build/libs/notificacao-0.0.1-SNAPSHOT.jar /app/notificacao.jar
expose 8082
CMD ["java","-jar","/app/notificacao.jar"]