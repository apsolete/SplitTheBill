package com.apsolete.splitthebill.ui.party;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.apsolete.splitthebill.MainActivity;
import com.apsolete.splitthebill.dao.MateDao;
import com.apsolete.splitthebill.dao.PartyDao;
import com.apsolete.splitthebill.entity.Mate;
import com.apsolete.splitthebill.entity.Party;

import java.util.List;

public class PartyViewModel extends ViewModel {
    private final MateDao mMateDao;
    private final MutableLiveData<String> mText;
    private final LiveData<List<Mate>> mMates;
    private final PartyDao mPartyDao;
    private LiveData<Party> mParty;

    public PartyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Company");

        mMateDao = MainActivity.getDb().mateDao();
        mPartyDao = MainActivity.getDb().partyDao();

        mMates = mMateDao.getAll();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Mate>> getAllMates() {
        return mMates;
    }

    public LiveData<Party> getParty() {
        mParty = mPartyDao.getActive();
        return mParty;
    }
}