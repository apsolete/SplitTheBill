package com.apsolete.splitthebill.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Bill;

import java.util.List;

@Dao
public interface BillDao {
    @Query("SELECT * FROM bills")
    List<Bill> getAllBills();
    @Insert
    void insert(Bill bill);
    @Delete
    void delete(Bill bill);
}
