# Сервис для авиаперелётов — Лабораторная работа №1 (Git)

Проект реализует простой консольный сервис для управления информацией о самолетах, рейсах и пассажирах.
Это учебный Java-проект — минимальная рабочая реализация для выполнения лабораторной работы по Git:
создание репозитория, ветвление, коммиты, теги, конфликт и откат изменений.

## Структура проекта
```
airline_lab_project/
├── .gitignore
├── CHANGELOG.md
├── README.md
└── src/
    └── main/
        └── java/
            └── com/example/airline/
                ├── model/
                │   ├── Airplane.java
                │   ├── Flight.java
                │   └── Passenger.java
                ├── service/
                │   ├── FlightService.java
                │   └── PassengerService.java
                └── Main.java
```

## Как запускать
1. Скомпилируйте проект (из корня проекта):
   ```bash
   javac -d out src/main/java/com/example/airline/**/*.java
   ```
2. Запустите:
   ```bash
   java -cp out com.example.airline.Main
   ```

## Git — рекомендованные шаги (пример)
```bash
git init
git add .
git commit -m "chore: initial project structure"
git checkout -b models
# добавить модели
git add src/main/java/com/example/airline/model
git commit -m "feat: add model classes"
git checkout main
git merge models
git tag v0.1

git checkout -b services
# добавить сервисы
git add src/main/java/com/example/airline/service
git commit -m "feat: add services"
git checkout main
git merge services
git tag v0.2

git checkout -b console-ui
# добавить Main.java
git add src/main/java/com/example/airline/Main.java
git commit -m "feat: add console UI"
git checkout main
git merge console-ui
git tag v0.3
```

## Что дальше (дополнительно)
- Можно расширить сохранение/загрузку данных в файл или БД (SQLite).
- Сделать тесты (JUnit).
- Добавить CLI parser (например, picocli) или GUI (JavaFX).
