# Базовый образ
FROM eclipse-temurin:17-jdk-alpine

# Рабочая директория
WORKDIR /app

# Копируем собранный JAR
COPY target/myProject-*.jar app.jar

# Порт приложения
EXPOSE 8080

# Команда запуска
ENTRYPOINT ["java", "-jar", "app.jar"]
