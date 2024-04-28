package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "splits",
        foreignKeys = {
            @ForeignKey(entity = Dish.class, parentColumns = "id", childColumns = "dishId"),
            @ForeignKey(entity = Mate.class, parentColumns = "id", childColumns = "mateId")
        })
public class Split {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long dishId;
    public long mateId;
}
