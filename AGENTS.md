# SplitTheBill

Android-приложение: разделение счетов. Пакет `com.apsolete.splitthebill`.

## Структура
- Один модуль `:app`, чистая Java (31 файл). Kotlin-плагин не подключён — добавлять Kotlin только с явной договорённости (нужны правки в build-скриптах).
- Стек: Room, ViewBinding, Navigation Component, Lifecycle (LiveData/ViewModel), Google Maps.
- minSdk 30, target/compileSdk 37, JVM-тулчейн 17.

## Сборка и проверка (Windows, из корня проекта)
- Сборка APK: `gradlew.bat assembleDebug`
- Юнит-тесты: `gradlew.bat test` — запускать после изменений в коде
- Инструментальные тесты: `gradlew.bat connectedAndroidTest` (нужен эмулятор/устройство)
- Линт: `gradlew.bat lint`
- После изменений в логах Gradle смотреть только ошибки/FAILED, не читать весь вывод.

## Окружение
- SDK: `C:\ProgramData\Android\Sdk` (подхватывается через `local.properties`, не коммитить его изменения).
- adb: `C:\ProgramData\Android\Sdk\platform-tools\adb.exe`; эмулятор доступен.
- Daemon JVM pinned на JDK 25 через `gradle/gradle-daemon-jvm.properties` (foojay автозагрузка) — файл коммитится, не удалять.

## Правила кода
- Room: схемы БД — в `app/schemas/` (создаются автоматически при сборке); коммитить их при изменении версии БД.
- Не редактировать вручную: `build/`, `.gradle/`, сгенерированные ViewBinding-классы.
- Новые зависимости — только после подтверждения.
- Не трогать `local.properties` и `gradle-daemon-jvm.properties` без необходимости.
