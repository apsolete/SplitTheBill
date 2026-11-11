package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mates")
public class Mate {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
}
