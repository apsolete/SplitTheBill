package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "partymates",
        foreignKeys = {
            @ForeignKey(entity = Party.class, parentColumns = "id", childColumns = "partyId"),
            @ForeignKey(entity = Mate.class, parentColumns = "id", childColumns = "mateId")
        })
public class PartyMate {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long partyId;
    public long mateId;
}
