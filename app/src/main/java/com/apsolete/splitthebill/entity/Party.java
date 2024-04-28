package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "parties")
public class Party {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String title;
    public String where;
    public Date date;
}
