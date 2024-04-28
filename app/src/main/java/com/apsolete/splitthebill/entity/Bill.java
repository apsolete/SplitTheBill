package com.apsolete.splitthebill.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "bills", foreignKeys = @ForeignKey(entity = Party.class, parentColumns = "id", childColumns = "partyId"))
public class Bill {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long partyId;
}
