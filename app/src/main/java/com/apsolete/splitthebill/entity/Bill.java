package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "bills")
public class Bill {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String party;
    public String where;
    public Date date;
}
