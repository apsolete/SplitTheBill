package com.apsolete.splitthebill.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.apsolete.splitthebill.entity.Dish;

import java.util.List;

@Dao
public interface DishDao {
    @Query("SELECT * FROM dishes WHERE billId = :billId") List<Dish> getBillDishes(long billId);
    @Insert
    void insert(Dish dish);
    @Delete
    void delete(Dish dish);
}
