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
public interface ParticipantDao {
    @Query("SELECT * FROM participants")
    LiveData<List<Participant>> getAll();
    @Query("SELECT mates.* FROM mates JOIN participants ON mates.id = participants.mateId AND participants.partyId = :partyId")
    LiveData<List<Mate>> getPartyGoers(long partyId);
    @Insert
    void insert(Participant participant);
    @Delete
    void delete(Participant participant);
}
