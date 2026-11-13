package com.apsolete.splitthebill.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Participant;

import java.util.List;

@Dao
public interface PartyGoerDao {
    @Query("SELECT * FROM Participant")
    LiveData<List<Participant>> getAll();
    @Query("SELECT mates.* FROM mates JOIN Participant ON mates.id = Participant.mateId AND Participant.partyId = :partyId")
    LiveData<List<Mate>> getPartyGoers(long partyId);
    @Insert
    void insert(Participant participant);
    @Delete
    void delete(Participant participant);
}
