package com.apsolete.splitthebill.ui.company;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompanyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CompanyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}