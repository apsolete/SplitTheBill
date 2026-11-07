package com.apsolete.splitthebill.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Party;

import java.util.List;

@Dao
public interface PartyDao {
    @Query("SELECT * FROM parties")
    LiveData<List<Party>> getAll();
    @Insert
    void insert(Party party);
    @Delete
    void delete(Party party);
}
