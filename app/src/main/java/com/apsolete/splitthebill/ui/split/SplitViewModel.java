package com.apsolete.splitthebill.ui.split;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SplitViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SplitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}