package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;

@Entity(tableName = "bills")
public class Bill {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String party;
    public String where;
    public Instant date;
}
