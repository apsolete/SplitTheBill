package com.apsolete.splitthebill.dao;

import androidx.room.TypeConverter;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;

public class Converters {
    @TypeConverter
    public static Instant fromTimestamp(Long value) {
        return value == null ? null : Instant.ofEpochSecond(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Instant date) {
        return date == null ? null : date.getEpochSecond();
    }
}
