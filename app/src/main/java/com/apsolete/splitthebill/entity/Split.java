package com.apsolete.splitthebill.entity;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "splits",
        foreignKeys = {
            @ForeignKey(entity = Dish.class, parentColumns = "id", childColumns = "dishId", onDelete = CASCADE),
            @ForeignKey(entity = Mate.class, parentColumns = "id", childColumns = "mateId", onDelete = CASCADE)
        },
        indices = {@Index("dishId"), @Index("mateId")})
public class Split {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long dishId;
    public long mateId;
}
