package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "dishes",
        foreignKeys = {@ForeignKey(entity = Bill.class, parentColumns = "id", childColumns = "billId")},
        indices = {@Index("billId")})
public class Dish {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long billId;
    public String name;
    public double cost;
}
