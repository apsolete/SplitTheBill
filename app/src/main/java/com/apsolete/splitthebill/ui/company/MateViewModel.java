package com.apsolete.splitthebill.ui.company;

import androidx.lifecycle.ViewModel;

import com.apsolete.splitthebill.MainActivity;
import com.apsolete.splitthebill.dao.MateDao;
import com.apsolete.splitthebill.entity.Mate;

import java.util.concurrent.Executors;

public class MateViewModel extends ViewModel {
    private final MateDao mMateDao;

    public MateViewModel() {
        mMateDao = MainActivity.getDb().mateDao();
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
}