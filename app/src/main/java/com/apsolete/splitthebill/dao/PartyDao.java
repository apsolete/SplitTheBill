package com.apsolete.splitthebill.dao;

import androidx.room.Dao;

import com.apsolete.splitthebill.entity.Party;

import java.util.List;

@Dao
public interface PartyDao {
    List<Party> getAll();
    Party getById(long id);
}
