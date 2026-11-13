package com.apsolete.splitthebill.dao;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.room.TypeConverters;

import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Bill;
import com.apsolete.splitthebill.entity.Dish;
import com.apsolete.splitthebill.entity.Participant;
import com.apsolete.splitthebill.entity.Party;
import com.apsolete.splitthebill.entity.Split;

@Database(version = 2, entities = {Party.class, Mate.class, Participant.class, Bill.class, Dish.class, Split.class})
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public static final String NAME = "SplitTheBillDatabase";
    private static AppDatabase instance;

    public abstract PartyDao partyDao();
    public abstract MateDao mateDao();
    public abstract PartyGoerDao partyGoerDao();
    public abstract BillDao billDao();
    public abstract DishDao dishDao();
    public abstract SplitDao splitDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
