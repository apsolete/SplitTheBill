package com.apsolete.splitthebill.dao;

import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;

import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Bill;
import com.apsolete.splitthebill.entity.Dish;
import com.apsolete.splitthebill.entity.Split;

@Database(version = 0, entities = {Mate.class, Bill.class, Dish.class, Split.class})
@TypeConverters({Converters.class})
public abstract class SplitTheBillDatabase extends RoomDatabase {
    public abstract MateDao mateDao();
    public abstract BillDao billDao();
    public abstract DishDao dishDao();
    public abstract SplitDao splitDao();
}
