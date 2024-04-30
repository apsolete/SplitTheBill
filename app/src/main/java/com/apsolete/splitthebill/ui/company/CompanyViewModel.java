package com.apsolete.splitthebill.ui.company;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.apsolete.splitthebill.MainActivity;
import com.apsolete.splitthebill.dao.AppDatabase;
import com.apsolete.splitthebill.entity.Mate;

import java.util.List;

public class CompanyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<Mate>> mates;

    public CompanyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        AppDatabase db = MainActivity.getDb();
        mates = new MutableLiveData<>(db.mateDao().getAll().getValue());
    }

    public LiveData<String> getText() {
        return mText;
    }
}