package com.apsolete.splitthebill.entity;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "participants",
        foreignKeys = {
            @ForeignKey(entity = Party.class, parentColumns = "id", childColumns = "partyId", onDelete = CASCADE),
            @ForeignKey(entity = Mate.class, parentColumns = "id", childColumns = "mateId", onDelete = CASCADE)
        },
        indices = {@Index("partyId"), @Index("mateId")}
)
public class Participant {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long partyId;
    public long mateId;
}
