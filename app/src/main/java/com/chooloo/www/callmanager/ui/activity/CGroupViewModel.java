package com.chooloo.www.callmanager.ui.activity;

import android.app.Application;

import com.chooloo.www.callmanager.database.AppDatabase;
import com.chooloo.www.callmanager.database.DataRepository;
import com.chooloo.www.callmanager.database.entity.CGroup;
import com.chooloo.www.callmanager.database.entity.Contact;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class CGroupViewModel extends AndroidViewModel {

    private DataRepository mRepository;

    private long mListId;
    private LiveData<List<Contact>> mContacts;

    public CGroupViewModel(@NonNull Application application) {
        super(application);
        mRepository = DataRepository.getInstance(AppDatabase.getDatabase(application.getApplicationContext()));
    }

    public void setListId(long listId) {
        mListId = listId;
        mContacts = mRepository.getContactsInList(listId);
    }

    public LiveData<List<Contact>> getContacts() {
        return mContacts;
    }

    public LiveData<List<CGroup>> getCGroup() {
        return mRepository.getCGroup(mListId);
    }
}
