package com.apsolete.splitthebill.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.PartyGoer;

import java.util.List;

@Dao
public interface PartyGoerDao {
    @Query("SELECT * FROM partygoers")
    LiveData<List<PartyGoer>> getAll();
    @Query("SELECT mates.* FROM mates JOIN partygoers ON mates.id = partygoers.mateId AND partygoers.partyId = :partyId")
    LiveData<List<Mate>> getPartyGoers(long partyId);
    @Insert
    void insert(PartyGoer partyGoer);
    @Delete
    void delete(PartyGoer partyGoer);
}
