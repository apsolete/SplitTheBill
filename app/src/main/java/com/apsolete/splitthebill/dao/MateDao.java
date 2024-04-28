package com.apsolete.splitthebill.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Mate;

import java.util.List;

@Dao
public interface MateDao {
    @Query("SELECT * FROM mates")
    List<Mate> getAll();
    @Insert
    void insert(Mate mate);
    @Delete
    void delete(Mate mate);
}
