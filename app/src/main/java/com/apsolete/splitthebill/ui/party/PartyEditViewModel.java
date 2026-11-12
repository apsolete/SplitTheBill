package com.apsolete.splitthebill.ui.party;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.apsolete.splitthebill.MainActivity;
import com.apsolete.splitthebill.dao.PartyDao;
import com.apsolete.splitthebill.entity.Party;

import java.util.concurrent.Executors;

public class PartyEditViewModel extends ViewModel {
    private final PartyDao mPartyDao;
    private LiveData<Party> mParty;

    public PartyEditViewModel() {
        mPartyDao = MainActivity.getDb().partyDao();
    }
    public void saveParty(Party party) {
        Executors.newSingleThreadExecutor().execute(() -> {
            mPartyDao.update(party);
        });
    }

    public void insertParty(Party party) {
        Executors.newSingleThreadExecutor().execute(() -> {
            mPartyDao.insert(party);
        });
    }

    public LiveData<Party> getParty() {
        mParty = mPartyDao.getActive();
        return mParty;
    }
}