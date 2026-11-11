package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;

@Entity(tableName = "parties")
public class Party {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String where;
    public Instant when;
    public boolean finished;
}
