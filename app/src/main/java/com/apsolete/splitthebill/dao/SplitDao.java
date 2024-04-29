package com.apsolete.splitthebill.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Split;

import java.util.List;

@Dao
public interface SplitDao {
    @Query("SELECT * FROM splits WHERE dishId = :dishId")
    List<Split> getDishSplits(long dishId);
    @Query("SELECT splits.* FROM splits, dishes WHERE splits.dishId = dishes.id AND dishes.billId = :billId")
    List<Split> getBillSplits(long billId);
    @Insert
    void insert(Split split);
    @Delete
    void delete(Split split);
}
