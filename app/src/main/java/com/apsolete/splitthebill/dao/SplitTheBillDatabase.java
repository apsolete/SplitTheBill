package com.apsolete.splitthebill.dao;

import androidx.room.Database;

import com.apsolete.splitthebill.entity.Bill;
import com.apsolete.splitthebill.entity.Dish;
import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Party;
import com.apsolete.splitthebill.entity.PartyMate;
import com.apsolete.splitthebill.entity.Split;

@Database(version = 0, entities = {Mate.class, Party.class, PartyMate.class, Dish.class, Bill.class, Split.class})
public abstract class SplitTheBillDatabase {
    public abstract MateDao mateDao();
    public abstract PartyDao partyDao();
}
