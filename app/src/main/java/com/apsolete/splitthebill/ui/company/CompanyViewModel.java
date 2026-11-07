package com.apsolete.splitthebill.ui.company;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.apsolete.splitthebill.MainActivity;
import com.apsolete.splitthebill.dao.MateDao;
import com.apsolete.splitthebill.entity.Mate;

import java.util.List;
import java.util.concurrent.Executors;

public class CompanyViewModel extends ViewModel {
    private final MateDao mMateDao;
    private final MutableLiveData<String> mText;
    private final LiveData<List<Mate>> mMates;

    public CompanyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Company");

        mMateDao = MainActivity.getDb().mateDao();
        mMates = mMateDao.getAll();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Mate>> getAllMates() {
        return mMates;
    }
}