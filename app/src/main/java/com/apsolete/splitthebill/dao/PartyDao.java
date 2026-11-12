package com.apsolete.splitthebill.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.apsolete.splitthebill.entity.Party;

import java.util.List;

@Dao
public interface PartyDao {
    @Query("SELECT * FROM parties")
    LiveData<List<Party>> getAll();
    @Query("SELECT * FROM parties WHERE finished=false LIMIT 1")
    LiveData<Party> getActive();
    @Query("SELECT * FROM parties WHERE id=:id")
    LiveData<List<Party>> getOne(long id);
    @Insert
    void insert(Party party);
    @Update
    void update(Party party);
    @Delete
    void delete(Party party);
}
