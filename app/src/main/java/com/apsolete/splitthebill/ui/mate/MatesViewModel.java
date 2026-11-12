package com.apsolete.splitthebill.ui.mate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.apsolete.splitthebill.MainActivity;
import com.apsolete.splitthebill.dao.MateDao;
import com.apsolete.splitthebill.entity.Mate;

import java.util.List;
import java.util.concurrent.Executors;

public class MatesViewModel extends ViewModel {
    private final MateDao mMateDao;
    private final LiveData<List<Mate>> mMates;

    public MatesViewModel() {
        mMateDao = MainActivity.getDb().mateDao();
        mMates = mMateDao.getAll();
    }

    public void saveMate(String name) {
        Mate mate = new Mate();
        mate.name = name;
        insertMate(mate);
    }

    private void insertMate(Mate mate) {
        Executors.newSingleThreadExecutor().execute(() -> {
            mMateDao.insert(mate);
        });
    }

    public LiveData<List<Mate>> getAllMates() {
        return mMates;
    }
}