package com.apsolete.splitthebill.dao;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Converters {
    @TypeConverter
    public static Instant fromTimestamp(Long value) {
        return value == null ? null : Instant.ofEpochSecond(value);
    }

    @TypeConverter
    public static Long toTimestamp(Instant date) {
        return date == null ? null : date.getEpochSecond();
    }

    public static Instant parseToInstant(String dateStr, String timeStr) {
        // 1. Парсим строки в LocalDate и LocalTime
        LocalDate date = LocalDate.parse(dateStr);
        LocalTime time = LocalTime.parse(timeStr);

        // 2. Объединяем в LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(date, time);

        // 3. Указываем часовой пояс (например, системный)
        ZoneId zoneId = ZoneId.systemDefault();
        // Или: ZoneId zoneId = ZoneId.of("Europe/Minsk");

        // 4. Получаем Instant
        return localDateTime.atZone(zoneId).toInstant();
    }

    public static Instant parseToInstant(String dateTimeStr) {
        // 1. Объединяем в LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr);

        // 2. Указываем часовой пояс (например, системный)
        ZoneId zoneId = ZoneId.systemDefault();
        // Или: ZoneId zoneId = ZoneId.of("Europe/Minsk");

        // 3. Получаем Instant
        return localDateTime.atZone(zoneId).toInstant();
    }

    public static String toDateString(Instant instant) {
        // 1. Указываем часовой пояс, в котором хотим получить время (например, системный или UTC)
        ZoneId zoneId = ZoneId.systemDefault(); // или ZoneId.of("Europe/Minsk")

        // 2. Переводим Instant в LocalDateTime с учетом часового пояса
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);

        // Задаем нужные форматы
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return localDateTime.toLocalDate().format(dateFormatter); // "2026-11-12"
    }

    public static String toTimeString(Instant instant) {
        // 1. Указываем часовой пояс, в котором хотим получить время (например, системный или UTC)
        ZoneId zoneId = ZoneId.systemDefault(); // или ZoneId.of("Europe/Minsk")

        // 2. Переводим Instant в LocalDateTime с учетом часового пояса
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);

        // Задаем нужные форматы
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return localDateTime.toLocalTime().format(timeFormatter); // "18:15"
    }

    public static String toDateTimeString(Instant instant) {
        // 1. Указываем часовой пояс, в котором хотим получить время (например, системный или UTC)
        ZoneId zoneId = ZoneId.systemDefault(); // или ZoneId.of("Europe/Minsk")

        // 2. Переводим Instant в LocalDateTime с учетом часового пояса
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);

        // Задаем нужные форматы
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return localDateTime.format(dateFormatter); // "2026-11-12 18:15"
    }
}
